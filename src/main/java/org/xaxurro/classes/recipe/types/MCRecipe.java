package org.xaxurro.classes.recipe.types;

import lombok.*;
import org.json.JSONObject;
import org.xaxurro.enums.RecipeType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipe {

    String name;
    RecipeType type;
    String category;
//    Ingredients | Items

//
//    Build Methods
//
    public static MCRecipe build (JSONObject json){
        MCRecipe recipe = new MCRecipe();
        String type = json.getString("type");
        type = type.substring(type.indexOf(":") + 1);
        recipe.setType(type.startsWith("crafting_special") || type.equals("crafting_decorated_pot") ? RecipeType.special: RecipeType.valueOf(type));
        return recipe;
    }

    public static MCRecipe build (String jsonString){
        JSONObject json = new JSONObject(jsonString);
        MCRecipe recipe = MCRecipe.build(json);

        switch (recipe.getType()){
            case crafting_shaped:
                recipe = MCRecipeShaped.buildFromJSON(json);
                break;
            case crafting_shapeless:
                recipe = MCRecipeShapeless.build(json);
                break;
        }

        if (json.has("category")) recipe.setCategory(json.getString("category"));

        return recipe;
    }

    public static MCRecipe build (File file) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(file.getPath())));
        MCRecipe recipe = MCRecipe.build(json);
        recipe.setName(file.getName());
        return recipe;
    }

    public static List<? extends MCRecipe> build (File[] files) throws IOException {
        List<MCRecipe> recipeList = new ArrayList<>();

        for (File file : files) {
            MCRecipe r = MCRecipe.build(file);

            if (r != null) recipeList.add(r);
        }
        return recipeList;
    }

//    TODO hacer que cuando se quiera escribir el archivo que verifique si la longitud del array es 1
//    TODO hacer que cada subclase tengo su propio metodo generateJsonFile, considerar usar interfaz

//
//    generateJSON Methods
//
    public File generateJSON(File outputFile) throws IOException{
        FileWriter fw = new FileWriter(outputFile);
        String json = new JSONObject(this).toString(2);
        fw.write(json);
        fw.close();
        return outputFile;
    }

    public File generateJSON(String outputFileName) throws IOException {
        return generateJSON(new File(outputFileName));
    }
}
