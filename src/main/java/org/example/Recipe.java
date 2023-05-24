package org.example;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Recipe {
    Ingredient output;
    int quantity;
    Map<Integer, Ingredient> recipe;

    public static Recipe build(Ingredient output, Map<Integer, String> recipeMap) {
        Recipe object = new Recipe();

        Map<Integer, Ingredient> recipe = new HashMap<>();
        for(Map.Entry<Integer, String> entry : recipeMap.entrySet()) {
            recipe.put(entry.getKey(), new Ingredient(entry.getValue()));
        }

        object.setOutput(output);
        object.setRecipe(recipe);
        return object;
    }
}
