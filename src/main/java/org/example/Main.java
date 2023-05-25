package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File[] files = new File("src/main/resources/Minecraft-Recipes").listFiles();

//        List<MCRecipe> recipeList = MCRecipe.build(files);
//        System.out.println(recipeList);

        MCRecipe recipe = MCRecipeShaped.build(new File("src/main/resources/Minecraft-Recipes/beacon.json"));
        System.out.println(recipe.getItem());
    }
}