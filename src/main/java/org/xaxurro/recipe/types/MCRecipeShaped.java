package org.xaxurro.recipe.types;

import lombok.*;
import org.xaxurro.recipe.MCRecipeException;
import org.xaxurro.recipe.properties.MCIngredient;
import org.xaxurro.recipe.properties.MCShape;
import org.xaxurro.recipe.properties.MCResult;
import org.json.JSONObject;
import org.xaxurro.enums.RecipeType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeShaped implements MCRecipe {
    String name;
    String group;
    String category;
    RecipeType type = RecipeType.crafting_shaped;
    MCShape shape;
    MCResult result;
    boolean notification;
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


    @Override
    public File generateJSON(File outputFile) throws IOException {
        FileWriter fw = new FileWriter(outputFile);

        JSONObject root = new JSONObject();

        JSONObject resultJSON = new JSONObject();
        resultJSON.put("item", result.getId());
        resultJSON.put("count", result.getCount());
        root.put("result", resultJSON);


        root.put("pattern", shape.getPattern());
        root.put("key", shape.toJSONObject());
        root.put("category", category);
        root.put("group", group);
        root.put("type", "minecraft:" + type);
        root.put("show_notification", notification);

        String json = root.toString(2);
        fw.write(json);
        fw.close();
        return outputFile;
    }
}
