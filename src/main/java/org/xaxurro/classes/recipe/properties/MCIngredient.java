package org.xaxurro.classes.recipe.properties;

import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xaxurro.classes.utils.IdUtils;
import org.xaxurro.enums.IngredientType;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class MCIngredient {
    String id;
    IngredientType ingredientType;

    public MCIngredient(String id) {
        IdUtils.isValidThrow(id);
        this.id = IdUtils.parse(id);
        this.ingredientType = IngredientType.Item;
    }

    public MCIngredient(String id, IngredientType type) {
        IdUtils.isValidThrow(id);
        this.id = IdUtils.parse(id);
        this.ingredientType = type;
    }
    
    public static MCIngredient buildFromJSON (JSONObject jsonObject) {
        if (jsonObject.has("item")) {
            return new MCIngredient(jsonObject.getString("item"), IngredientType.Item);
        }
        return new MCIngredient(jsonObject.getString("tag"), IngredientType.Tag);
    }
    public static List<MCIngredient> buildFromJSON (JSONArray jsonArray) {
        List<MCIngredient> ingredientList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            MCIngredient ingredient = new MCIngredient(jsonArray.getJSONObject(i).getString("item"));
            ingredientList.add(ingredient);
        }

        return ingredientList;
    }
}
