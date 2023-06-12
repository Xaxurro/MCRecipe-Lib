package org.example.classes.recipeTypes;

import org.json.JSONObject;

public class MCRecipeSmoking extends MCRecipe{
    String type = "minecraft:smoking";

    public static MCRecipeSmoking build(JSONObject json) {
        return (MCRecipeSmoking) MCRecipe.build(json);
    }
}
