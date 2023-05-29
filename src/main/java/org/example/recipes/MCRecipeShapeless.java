package org.example.recipes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MCRecipeShapeless extends MCRecipe{
    String type = "minecraft:crafting_shapeless";

    public static MCRecipeShapeless build(File json, ObjectMapper om) throws IOException {
        return (MCRecipeShapeless) MCRecipe.build(json, om);
    }
}
