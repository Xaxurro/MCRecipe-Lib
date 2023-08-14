package org.xaxurro.classes.recipe.types;

import org.json.JSONObject;

public class MCRecipeStonecutting extends MCRecipe{
    String type = "minecraft:stonecutting";

    public static MCRecipeStonecutting build(JSONObject json) {
        return (MCRecipeStonecutting) MCRecipe.build(json);
    }
}
