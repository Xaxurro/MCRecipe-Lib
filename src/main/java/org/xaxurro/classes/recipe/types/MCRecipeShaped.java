package org.xaxurro.classes.recipe.types;

import lombok.*;
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
public class MCRecipeShaped extends MCRecipe {
    RecipeType type = RecipeType.crafting_shaped;
    MCShape shape;
    MCResult result;

//    Look at these files for a MCRecipeShaped reference:
//    -beacon.json (Simple Shape)
//    -purpur_slab (2 Valid Blocks)
//    -wooden_pickaxe (Tag use)
//    
//    .BUILD METHODS
//    

    public static MCRecipeShaped buildFromJSON(String jsonString) {
        return (MCRecipeShaped) MCRecipe.build(jsonString);
    }

    public static MCRecipeShaped buildFromFile(File file) throws IOException {
        return (MCRecipeShaped) MCRecipe.build(file);
    }

    public static List<MCRecipeShaped> buildFromJSON(File[] files) throws IOException {
        List<MCRecipeShaped> recipeList = new ArrayList<>();
        for (MCRecipe r :  MCRecipe.build(files)) {
            if (r instanceof MCRecipeShaped) recipeList.add((MCRecipeShaped) r);
        }
        return recipeList;
    }
    
    public static MCRecipeShaped buildFromJSON(JSONObject json){
        MCRecipeShaped recipe = new MCRecipeShaped();

        recipe.buildShape(json);

        recipe.buildResult(json);

        return recipe;
    }

    private void buildShape(JSONObject json) {
        MCShape shape = MCShape.buildFromJSON(json);

        this.shape = shape;
    }


    private void buildResult(JSONObject json) {
        MCResult result = MCResult.buildFromJSON(json.getJSONObject("result"));

        this.result = result;
    }

    public List<MCIngredient> getIngredients() {
        return this.shape.getIngredients();
    }
}
