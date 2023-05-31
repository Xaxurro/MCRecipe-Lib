package org.example.classes.recipeTypes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MCRecipeSmelting extends MCRecipe{
    String type = "minecraft:smelting";

    public static MCRecipeSmelting build(File json, ObjectMapper om) throws IOException {
        return (MCRecipeSmelting) MCRecipe.build(json, om);
    }
}
