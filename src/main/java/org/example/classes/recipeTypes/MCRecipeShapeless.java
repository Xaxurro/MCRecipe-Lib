package org.example.classes.recipeTypes;

import lombok.*;
import org.example.classes.MCIngredient;
import org.json.JSONObject;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeShapeless extends MCRecipe{
    String type = "minecraft:crafting_shapeless";
    MCIngredient[] ingredients;
    MCIngredient item;
    int count;

    public static MCRecipeShapeless build(JSONObject json){
        MCRecipeShapeless recipe = new MCRecipeShapeless();

//        TODO terminar lol

        return recipe;
    }
}
