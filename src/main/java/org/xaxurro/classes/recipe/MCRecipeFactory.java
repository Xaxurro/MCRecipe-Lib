package org.xaxurro.classes.recipe;

import org.json.JSONObject;
import org.xaxurro.classes.MCRecipeException;
import org.xaxurro.classes.recipe.types.*;
import org.xaxurro.enums.RecipeType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.xaxurro.enums.RecipeType.crafting_shaped;
import static org.xaxurro.enums.RecipeType.crafting_shapeless;

public final class MCRecipeFactory {
    private static RecipeType getRecipeType(JSONObject json){
        String type = json.getString("type");
        type = type.substring(type.indexOf(":") + 1);
        return (type.startsWith("crafting_special") || type.equals("crafting_decorated_pot") ? RecipeType.special: RecipeType.valueOf(type));
    }

    public static MCRecipeBlasting blasting(JSONObject json) {
        System.out.println("SIN JSON");
        return new MCRecipeBlasting();
    }
    public static MCRecipeCampfireCooking campfire(JSONObject json) {
        System.out.println("SIN JSON");
        return new MCRecipeCampfireCooking();
    }
    public static MCRecipeShaped shaped(JSONObject json) {
        return new MCRecipeShaped(json);
    }
    public static MCRecipeShapeless shapeless(JSONObject json) {
        System.out.println("SIN JSON");
        return new MCRecipeShapeless();
    }
    public static MCRecipeSmelting smelting(JSONObject json) {
        System.out.println("SIN JSON");
        return new MCRecipeSmelting();
    }
    public static MCRecipeSmithing smithing(JSONObject json) {
        System.out.println("SIN JSON");
        return new MCRecipeSmithing();
    }
    public static MCRecipeSmoking smoking(JSONObject json) {
        System.out.println("SIN JSON");
        return new MCRecipeSmoking();
    }
    public static MCRecipeStonecutting stonecutting(JSONObject json) {
        System.out.println("SIN JSON");
        return new MCRecipeStonecutting();
    }

    public static MCRecipe buildFromJSONString(String jsonString) throws MCRecipeException {
        JSONObject json = new JSONObject(jsonString);
        MCRecipe recipe;
        RecipeType type = getRecipeType(json);

        switch (type){
            case blasting:
                recipe = MCRecipeFactory.blasting(json);
                break;
            case campfire_cooking:
                recipe = MCRecipeFactory.campfire(json);
                break;
            case crafting_shaped:
                recipe = MCRecipeFactory.shaped(json);
                break;
            case crafting_shapeless:
                recipe = MCRecipeFactory.shapeless(json);
                break;
            case smelting:
                recipe = MCRecipeFactory.smelting(json);
                break;
            case smithing_trim:
                recipe = MCRecipeFactory.smithing(json);
                break;
            case smithing_transform:
                recipe = MCRecipeFactory.smithing(json);
                break;
            case smoking:
                recipe = MCRecipeFactory.smoking(json);
                break;
            case stonecutting:
                recipe = MCRecipeFactory.stonecutting(json);
                break;
            default:
                throw new MCRecipeException("Special or invalid Recipe");
        }

        if (json.has("category")) recipe.setCategory(json.getString("category"));

        return recipe;
    }

    public static MCRecipe buildFromFile(File file) throws IOException, MCRecipeException {
        String json = new String(Files.readAllBytes(Paths.get(file.getPath())));
        MCRecipe recipe = buildFromJSONString(json);
        recipe.setName(file.getName());
        return recipe;
    }

    public static List<MCRecipe> buildFromFiles(File[] files) throws IOException, MCRecipeException {
        List<MCRecipe> recipeList = new ArrayList<>();

        for (File file : files) {
            MCRecipe r = buildFromFile(file);
            if (r != null) recipeList.add(r);
        }
        return recipeList;
    }
}
