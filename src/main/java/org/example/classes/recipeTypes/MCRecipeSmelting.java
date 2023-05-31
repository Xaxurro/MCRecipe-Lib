package org.example.classes.recipeTypes;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class MCRecipeSmelting extends MCRecipe{
    String type = "minecraft:smelting";

    public static MCRecipeSmelting build(JSONObject json) {
        return (MCRecipeSmelting) MCRecipe.build(json);
    }
}
