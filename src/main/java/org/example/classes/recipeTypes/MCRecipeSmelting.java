package org.example.classes.recipeTypes;

import org.json.JSONObject;

public class MCRecipeSmelting extends MCRecipe{
    String type = "minecraft:smelting";

    public static MCRecipeSmelting build(JSONObject json) {
        return (MCRecipeSmelting) MCRecipe.build(json);
    }
}
