package org.xaxurro.classes.recipe.types;

import org.json.JSONObject;

public class MCRecipeSmoking extends MCRecipe{
    String type = "minecraft:smoking";

    public static MCRecipeSmoking build(JSONObject json) {
        return (MCRecipeSmoking) MCRecipe.build(json);
    }
}
