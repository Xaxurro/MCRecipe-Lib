package org.xaxurro.recipe.types;

import lombok.*;
import org.json.JSONObject;
import org.xaxurro.recipe.properties.MCIngredient;
import org.xaxurro.recipe.properties.MCResult;
import org.xaxurro.enums.RecipeType;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeShapeless implements MCRecipe {
    String name;
    String category;
    RecipeType type = RecipeType.crafting_shapeless;
    MCIngredient ingredients;
    MCResult result;

    public MCRecipeShapeless(JSONObject json){
//        MCRecipeShapeless recipe = new MCRecipeShapeless();

//        recipe.buildIngredients(json);
//
//        recipe.buildResult(json);

//        TODO terminar lol

//        return recipe;
    }

    @Override
    public File generateJSON(File outputFile) throws IOException {
        return null;
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
}
