package org.xaxurro.classes.recipe.types;

import org.json.JSONObject;

public class MCRecipeBlasting extends MCRecipe{
    String type = "minecraft:blasting";

    public static MCRecipeBlasting build(JSONObject json){
        return (MCRecipeBlasting) MCRecipe.build(json);
    }
}
