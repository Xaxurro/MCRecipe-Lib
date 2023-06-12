package org.example.classes.recipeTypes;

import org.json.JSONObject;

public class MCRecipeStonecutting extends MCRecipe{
    String type = "minecraft:stonecutting";

    public static MCRecipeStonecutting build(JSONObject json) {
        return (MCRecipeStonecutting) MCRecipe.build(json);
    }
}
