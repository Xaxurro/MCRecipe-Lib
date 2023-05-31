package org.example;

import org.example.classes.MCIngredient;
import org.example.classes.recipeTypes.MCRecipe;
import org.example.classes.recipeTypes.MCRecipeShaped;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] a) throws IOException {
        File[] files = new File("src/main/resources/Minecraft-Recipes").listFiles();

        MCIngredient diamond = new MCIngredient("minecraft:diamond");
        MCIngredient stick = new MCIngredient("minecraft:stick");
        MCIngredient string = new MCIngredient("minecraft:string");

        MCIngredient diamondPickaxe = new MCIngredient("minecraft:diamond_pickaxe");

        MCRecipeShaped diamondPickaxeAlt = new MCRecipeShaped();
        diamondPickaxeAlt.setItem(diamondPickaxe);

        String[] pattern = new String[] {"XSX"," # "," # "};
        diamondPickaxeAlt.setPattern(pattern);

        Map<String, MCIngredient> keys = new HashMap<>();
        keys.put("X", diamond);
        keys.put("S", string);
        keys.put("#", stick);
        diamondPickaxeAlt.setKeys(keys);

        diamondPickaxeAlt.createJSON("diamond_pickaxe_alt.json");

//        MCRecipeShaped recipe = (MCRecipeShaped) MCRecipe.build(new File("src/main/resources/Minecraft-Recipes/beacon.json"));
//        recipe.createJSON("test.json");


    }
}