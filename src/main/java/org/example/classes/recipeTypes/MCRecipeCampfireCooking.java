package org.example.classes.recipeTypes;


import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class MCRecipeCampfireCooking extends MCRecipe{
    String type = "minecraft:campfire_cooking";

    public static MCRecipeCampfireCooking build(JSONObject json){
        return (MCRecipeCampfireCooking) MCRecipe.build(json);
    }
}
