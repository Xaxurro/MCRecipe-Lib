package org.xaxurro.classes.recipe.types;

import lombok.*;
import org.xaxurro.classes.MCRecipeException;
import org.xaxurro.classes.recipe.properties.MCIngredient;
import org.xaxurro.classes.recipe.properties.MCShape;
import org.xaxurro.classes.recipe.properties.MCResult;
import org.json.JSONObject;
import org.xaxurro.enums.RecipeType;

import java.io.File;
import java.io.IOException;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeShaped implements MCRecipe {
    String name;
    String category;
    RecipeType type = RecipeType.crafting_shaped;
    MCShape shape;
    MCResult result;
//    Look at these files for a MCRecipeShaped reference:
//    -beacon (Simple Shape)
//    -purpur_slab (2 Valid Blocks)
//    -wooden_pickaxe / stone_pickaxe (Tag use)


    public MCRecipeShaped(JSONObject json){
        this.shape = MCShape.buildFromJSON(json);
        this.result = MCResult.buildFromJSON(json.getJSONObject("result"));
    }

    public void setShape(MCShape shape) throws MCRecipeException {
        if (!shape.isPatternValid()) throw new MCRecipeException("Pattern is invalid");
        this.shape = shape;
    }

    public List<MCIngredient> getIngredients() {
        return this.shape.getIngredients();
    }
}
