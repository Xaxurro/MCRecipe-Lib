package org.xaxurro.classes.recipe.types;

import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xaxurro.classes.recipe.properties.MCIngredient;
import org.xaxurro.classes.recipe.properties.MCResult;
import org.xaxurro.enums.RecipeType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeShapeless extends MCRecipe {
    RecipeType type = RecipeType.crafting_shapeless;
    MCIngredient ingredients;
    MCResult result;

    public static MCRecipeShapeless build (String jsonString) {
        return (MCRecipeShapeless) MCRecipe.build(jsonString);
    }

    public static MCRecipeShapeless build (File file) throws IOException {
        return (MCRecipeShapeless) MCRecipe.build(file);
    }

    public static List<MCRecipeShapeless> build (File[] files) throws IOException {
        List<MCRecipeShapeless> recipeList = new ArrayList<>();
        for (MCRecipe r :  MCRecipe.build(files)) {
            if (r instanceof MCRecipeShapeless) recipeList.add((MCRecipeShapeless) r);
        }
        return recipeList;
    }

    public static MCRecipeShapeless build(JSONObject json){
        MCRecipeShapeless recipe = new MCRecipeShapeless();

//        recipe.buildIngredients(json);
//
//        recipe.buildResult(json);

//        TODO terminar lol

        return recipe;
    }

//    private void buildIngredients(JSONObject json) {
//        List<MCIngredient> ingredientList = new ArrayList<>();
//
//        JSONArray jsonArray = json.getJSONArray("ingredients");
//        for (int i = 0; i < jsonArray.length(); i++) {
//            ingredientList.add(MCIngredient.buildFromJSON(jsonArray.get(i)));
//        }
//
//        this.ingredients = ingredientList.toArray(new MCIngredient[0]);
//    }
//
//    private void buildResult(JSONObject json) {
//        JSONObject result = json.getJSONObject("result");
//        this.result = MCIngredient.buildFromJSON(result);
//        if (result.has("count")) this.count = result.getInt("count");
//    }

//    private void buildFromJSON
}