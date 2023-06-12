package org.example.classes.recipeTypes;


import org.json.JSONObject;

public class MCRecipeCampfireCooking extends MCRecipe{
    String type = "minecraft:campfire_cooking";

    public static MCRecipeCampfireCooking build(JSONObject json){
        return (MCRecipeCampfireCooking) MCRecipe.build(json);
    }
}
