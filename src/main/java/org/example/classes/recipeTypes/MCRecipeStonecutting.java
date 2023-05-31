package org.example.classes.recipeTypes;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class MCRecipeStonecutting extends MCRecipe{
    String type = "minecraft:stonecutting";

    public static MCRecipeStonecutting build(JSONObject json) {
        return (MCRecipeStonecutting) MCRecipe.build(json);
    }
}
