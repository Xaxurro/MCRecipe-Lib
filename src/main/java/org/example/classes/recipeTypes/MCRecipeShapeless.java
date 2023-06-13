package org.example.classes.recipeTypes;

import lombok.*;
import org.example.classes.MCIngredient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeShapeless extends MCRecipe{
    String type = "minecraft:crafting_shapeless";
    MCIngredient[] ingredients;
    MCIngredient result;
    int count;

    public static MCRecipeShapeless build(JSONObject json){
        MCRecipeShapeless recipe = new MCRecipeShapeless();

        recipe.buildIngredients(json);

        recipe.buildResult(json);

//        TODO terminar lol

        return recipe;
    }

    private void buildIngredients(JSONObject json) {
        List<MCIngredient> ingredientList = new ArrayList<>();

        JSONArray jsonArray = json.getJSONArray("ingredients");
        for (int i = 0; i < jsonArray.length(); i++) {
            ingredientList.add(MCIngredient.build(jsonArray.getJSONObject(i)));
        }

        this.ingredients = ingredientList.toArray(new MCIngredient[0]);
    }

    private void buildResult(JSONObject json) {
        JSONObject result = json.getJSONObject("result");
        this.result = MCIngredient.build(result);
        if (result.has("count")) this.count = result.getInt("count");
    }

//    private void build
}
