package org.example.classes.recipeTypes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MCRecipeStonecutting extends MCRecipe{
    String type = "minecraft:stonecutting";

    public static MCRecipeStonecutting build(File json, ObjectMapper om) throws IOException {
        return (MCRecipeStonecutting) MCRecipe.build(json, om);
    }
}
