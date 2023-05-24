package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Ingredient diamondPickaxe = new Ingredient("diamond_pickaxe");
        Map<Integer, String> recipeMap = new HashMap<Integer, String>();
        recipeMap.put(0, "diamond");
        recipeMap.put(1, "diamond");
        recipeMap.put(2, "diamond");
        recipeMap.put(4, "stick");
        recipeMap.put(7, "stick");

        Recipe diamondPickaxeRecipe = Recipe.build(diamondPickaxe, recipeMap);

        System.out.println(diamondPickaxeRecipe);
    }
}