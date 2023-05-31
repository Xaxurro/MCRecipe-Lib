package org.example.classes.recipeTypes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MCRecipeSmoking extends MCRecipe{
    String type = "minecraft:smoking";

    public static MCRecipeSmoking build(File json, ObjectMapper om) throws IOException {
        return (MCRecipeSmoking) MCRecipe.build(json, om);
    }
}
