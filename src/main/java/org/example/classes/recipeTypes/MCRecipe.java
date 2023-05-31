package org.example.classes.recipeTypes;

import lombok.*;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static MCRecipe build (JSONObject json){
        MCRecipe recipe = new MCRecipe();
        String type = json.getString("type");
        recipe.setType(type);

//        String group = json.getString("group");
//        recipe.setGroup(group);
        return recipe;
    }

    public static MCRecipe build (String jsonString){
        JSONObject json = new JSONObject(jsonString);
        MCRecipe recipe = MCRecipe.build(json);

        if (recipe.getType().startsWith("minecraft:crafting_special")) {
            return recipe;
        }

        switch (recipe.getType()){
            case "minecraft:crafting_shaped":
                recipe = MCRecipeShaped.build(json);
                break;
            case "minecraft:crafting_shapeless":
                recipe = MCRecipeShapeless.build(json);
                break;
        }

        return recipe;
    }

    public static MCRecipe build (File file) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(file.getPath())));
        return MCRecipe.build(json);
    }

    public static List<MCRecipe> build (File[] jsons) throws IOException {
        List<MCRecipe> recipeList = new ArrayList<>();

        for (File json : jsons) {
            MCRecipe r = MCRecipe.build(json);

            if (r != null) recipeList.add(r);
        }
        return recipeList;
    }

//    TODO hacer que cuando se quiera escribir el archivo que verifique si la longitud del array es 1
//    TODO hacer que cada subclase tengo su propio metodo createJsonFile, considerar usar interfaz

    public File createJSON(File outputFile) throws IOException{
        FileWriter fw = new FileWriter(outputFile);
        String json = new JSONObject(this).toString(2);
        fw.write(json);
        fw.close();
        return outputFile;
    }

    public File createJSON(String outputFile) throws IOException {
        return createJSON(new File(outputFile));
    }

}
