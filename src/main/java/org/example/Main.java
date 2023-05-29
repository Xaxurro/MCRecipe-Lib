package org.example;

import org.example.recipes.MCRecipe;
import org.example.recipes.MCRecipeShaped;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] a) throws IOException {
        File[] files = new File("src/main/resources/Minecraft-Recipes").listFiles();

//        List<MCRecipe> recipeList = MCRecipe.build(files);
//        System.out.println(recipeList);

        MCRecipeShaped recipe = (MCRecipeShaped) MCRecipe.build(new File("src/main/resources/Minecraft-Recipes/beacon.json"));
        recipe.createJSON("test.json");


    }
}