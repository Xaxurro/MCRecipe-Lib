package org.example.classes.recipeTypes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MCRecipeBlasting extends MCRecipe{
    String type = "minecraft:blasting";

    public static MCRecipeBlasting build(File json, ObjectMapper om) throws IOException {
        return (MCRecipeBlasting) MCRecipe.build(json, om);
    }
}
