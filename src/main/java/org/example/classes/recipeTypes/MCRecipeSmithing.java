package org.example.classes.recipeTypes;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class MCRecipeSmithing extends MCRecipe{
    String type = "minecraft:smithing";

    public static MCRecipeSmithing build(JSONObject json) {
        return (MCRecipeSmithing) MCRecipe.build(json);
    }
}
