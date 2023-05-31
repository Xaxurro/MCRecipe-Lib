package org.example.classes.recipeTypes;

import lombok.*;
import org.example.classes.MCIngredient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeShaped extends MCRecipe{
    String type = "minecraft:crafting_shaped";
    Map<String, MCIngredient> keys;
    String[] pattern;
    MCIngredient item;
    int count = 1;

//    Look at beacon.json for reference
    public static MCRecipeShaped build(JSONObject json){
        MCRecipeShaped recipe = new MCRecipeShaped();

        recipe.buildPattern(json);

        recipe.buildKeys(json);

        recipe.buildResult(json);

        return recipe;
    }

    private void buildPattern(JSONObject json) {
        JSONArray jsonArray = json.getJSONArray("pattern");
        List<String> patternList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            patternList.add(jsonArray.getString(i));
        }

        this.pattern = patternList.toArray(new String[patternList.size()]);
    }

    private void buildKeys(JSONObject json) {
        Map<String, MCIngredient> keys = new HashMap<>();
        JSONObject jsonKeys = json.getJSONObject("key");
        for (String k : jsonKeys.keySet()) {
            MCIngredient v = null;

            Object jsonValue = jsonKeys.get(k);
            if (jsonValue instanceof JSONObject) {
                v = MCIngredient.build((JSONObject) jsonValue);
            } else if (jsonValue instanceof JSONArray) {
                v = MCIngredient.build((JSONArray) jsonValue);
            }
            keys.put(k, v);
        }

        this.keys = keys;
    }

    private void buildResult(JSONObject json) {
        MCIngredient item = MCIngredient.build(json.getJSONObject("result"));
        this.item = item;
        if (json.has("count")){
            this.count = json.optInt("count", 1);
        }
    }
}
