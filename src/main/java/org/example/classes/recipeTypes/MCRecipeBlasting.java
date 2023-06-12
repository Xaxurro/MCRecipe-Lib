package org.example.classes.recipeTypes;

import org.json.JSONObject;

public class MCRecipeBlasting extends MCRecipe{
    String type = "minecraft:blasting";

    public static MCRecipeBlasting build(JSONObject json){
        return (MCRecipeBlasting) MCRecipe.build(json);
    }
}
