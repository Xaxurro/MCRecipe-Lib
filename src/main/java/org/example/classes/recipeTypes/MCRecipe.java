package org.example.classes.recipeTypes;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipe {
    String type;
    String group;
//    Ingredients | Items

    public static MCRecipe build (JsonNode json, ObjectMapper om) throws JsonProcessingException {
        MCRecipe recipe = new MCRecipe();
        String type = json.findValue("type").asText();
        recipe.setType(type);

        return recipe;
    }

    public static MCRecipe build (File json, ObjectMapper om) throws IOException {
        JsonNode jsonNode = om.readTree(json);

        MCRecipe recipe = MCRecipe.build(jsonNode, om);

        if (recipe.getType().startsWith("minecraft:crafting_special")) {
            return recipe;
        }

        switch (recipe.getType()){
            case "minecraft:crafting_shaped":
                recipe = MCRecipeShaped.build(jsonNode, om);
                break;
            case "minecraft:crafting_shapeless":
                recipe = MCRecipeShapeless.build(jsonNode, om);
                break;
            default:
                recipe = MCRecipe.build(jsonNode, om);
        }

        return recipe;
    }

    public static MCRecipe build (File json) throws IOException {
        ObjectMapper om = new ObjectMapper();
        return MCRecipe.build(json, om);
    }

    public static List<MCRecipe> build (File[] jsons) throws IOException {
        List<MCRecipe> recipeList = new ArrayList<>();
        ObjectMapper om = new ObjectMapper();

        for (File json : jsons) {
            MCRecipe r = MCRecipe.build(json, om);
            if (r != null) recipeList.add(r);
        }
        return recipeList;
    }

    public File createJSON(File outputFile) throws IOException {
        ObjectMapper om = new ObjectMapper();

        ObjectWriter w = om.writer(new DefaultPrettyPrinter());

        w.writeValue(outputFile, this);
        return outputFile;
    }

    public File createJSON(String outputFile) throws IOException {
        return createJSON(new File(outputFile));
    }

}
