package org.example.classes.recipeTypes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MCRecipeSmithing extends MCRecipe{
    String type = "minecraft:smithing";

    public static MCRecipeSmithing build(File json, ObjectMapper om) throws IOException {
        return (MCRecipeSmithing) MCRecipe.build(json, om);
    }
}
