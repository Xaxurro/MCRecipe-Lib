package org.example.recipes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MCRecipeCampfireCooking extends MCRecipe{
    String type = "minecraft:campfire_cooking";

    public static MCRecipeCampfireCooking build(File json, ObjectMapper om) throws IOException {
        return (MCRecipeCampfireCooking) MCRecipe.build(json, om);
    }
}
