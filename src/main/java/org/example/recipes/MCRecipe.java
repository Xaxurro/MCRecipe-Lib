package org.example.recipes;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
    String item;
    String category;
    String group;
    int count = 1;
//    Ingredients | Items

    public static MCRecipe build (File json, ObjectMapper om) throws IOException {
        MCRecipe recipe = new MCRecipe();
        JsonNode jsonNode = om.readTree(json);

        String type = jsonNode.findValue("type").asText();
        if (type.startsWith("minecraft:crafting_special")) {
            return recipe;
        }
        switch (type){
            case "minecraft:crafting_shaped":
                recipe = MCRecipeShaped.build(jsonNode, om);
                break;
            case "minecraft:crafting_shapeless":
                recipe = MCRecipeShapeless.build(json, om);
                break;
        }
        recipe.setType(type);
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
