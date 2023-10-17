package org.xaxurro.recipe.properties;

import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xaxurro.recipe.JSONAble;
import org.xaxurro.classes.utils.IdUtils;
import org.xaxurro.enums.IngredientType;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MCIngredient implements JSONAble {
    String id;
    IngredientType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType ingredientType) {
        this.type = ingredientType;
    }

    public MCIngredient(String id) {
        IdUtils.isValidThrow(id);
        this.id = IdUtils.parse(id);
        this.type = IngredientType.Item;
    }

    public MCIngredient(String id, IngredientType type) {
        IdUtils.isValidThrow(id);
        this.id = IdUtils.parse(id);
        this.type = type;
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

    @Override
    public JSONObject toJSONObject() {
        return new JSONObject().put(type.toString(), id);
    }
}
