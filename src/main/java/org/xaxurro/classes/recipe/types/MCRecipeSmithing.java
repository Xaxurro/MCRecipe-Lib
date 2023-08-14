package org.xaxurro.classes.recipe.types;

import org.json.JSONObject;

public class MCRecipeSmithing extends MCRecipe{
    String type = "minecraft:smithing";

    public static MCRecipeSmithing build(JSONObject json) {
        return (MCRecipeSmithing) MCRecipe.build(json);
    }
}
