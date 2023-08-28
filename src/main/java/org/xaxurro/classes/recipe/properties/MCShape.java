package org.xaxurro.classes.recipe.properties;

import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xaxurro.enums.IngredientType;

import java.util.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class MCShape {
    String[] pattern;
    Map<String, List<MCIngredient>> keys = new HashMap<>();

    public static MCShape buildFromJSON(JSONObject json) {
        MCShape pattern = new MCShape();

        JSONArray jsonArray = json.getJSONArray("pattern");
        List<String> patternList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            patternList.add(jsonArray.getString(i));
        }

        pattern.pattern = patternList.toArray(new String[]{});


        Map<String, List<MCIngredient>> keys = new HashMap<>();
        JSONObject jsonKeys = json.getJSONObject("key");
        for (String k : jsonKeys.keySet()) {
            Object jsonValue = jsonKeys.get(k);
            if (jsonValue instanceof JSONArray) {
                List<MCIngredient> vList = MCIngredient.buildFromJSON((JSONArray) jsonValue);
                keys.put(k, vList);
            }
            if (jsonValue instanceof JSONObject) {
                MCIngredient v = MCIngredient.buildFromJSON((JSONObject) jsonValue);
                keys.put(k, Collections.singletonList(v));
            }
        }

        pattern.keys = keys;

        return pattern;
    }

//    public void setPattern(String[] pattern, Map<String, List<MCIngredient>> keys) {
//        if (!isPatternValid(pattern, keys.keySet())) {
//            throw new RuntimeException("Pattern does not match Key Set");
//        }
//    }
//
//    public void setPattern(String[] pattern) {
//        if (!isPatternValid(pattern, keys.keySet())) {
//            throw new RuntimeException("Pattern does not match Key Set");
//        }
//    }

    public void addKey(String key, List<MCIngredient> ingredients) {
        if (keys.containsKey(key)) {
            keys.get(key).addAll(ingredients);
        } else {
            keys.put(key, ingredients);
        }
    }

    public void addKey(String key, MCIngredient ingredient) {
        if (keys.containsKey(key)) {
            keys.get(key).add(ingredient);
        } else {
            keys.put(key, Collections.singletonList(ingredient));
        }
    }

    public void addItem(String key, String ingredient) {
        addKey(key, new MCIngredient(ingredient, IngredientType.Item));
    }
    public void addTag(String key, String ingredient) {
        addKey(key, new MCIngredient(ingredient, IngredientType.Tag));
    }

    public List<MCIngredient> getIngredients() {
        List<MCIngredient> ingredients = new ArrayList<>();

        for (List<MCIngredient> value : keys.values()) {
            ingredients.addAll(value);
        }

        return ingredients;
    }

    private boolean isPatternValid(String[] pattern, Set<String> keySet) {
        if (pattern == null) return false;
        if (keySet.size() == 0) return false;

        Set<String> charSet = new HashSet<>();
        for (String line : pattern) {
            for (int i = 0; i < line.length(); i++) {
                charSet.add(String.valueOf(line.charAt(i)));
            }
        }

        for (String key : keySet) {
            if (!charSet.contains(key)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPatternValid() {
        return isPatternValid(pattern, keys.keySet());
    }

    public void setKeys(Map<String, List<MCIngredient>> keys) {
        if (keys != null) this.keys = keys;
        else this.keys = new HashMap<>();
    }
}
