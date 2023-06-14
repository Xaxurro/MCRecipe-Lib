package org.example.classes;

import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCIngredient {
    String[] ids;
    String type;

    public MCIngredient(String id, String type) {
        this.ids = new String[]{ id };
        this.type = type;
    }
    public MCIngredient(String id) {
        this.ids = new String[]{ id };
        this.type = "item";
    }

    public static MCIngredient build(Object object) {
//        TODO evitar usar Object
        if (object instanceof JSONObject) return build((JSONObject) object);
        if (object instanceof JSONArray) return build((JSONArray) object);
        return null;
    }

    public static MCIngredient build(JSONObject jsonObject) {
//        TODO: purpur_slab.json tiene 2 posibles items en vez de un tag
        MCIngredient ingredient = new MCIngredient();
        String type = (jsonObject.has("item") ? "item" : "tag");
        ingredient.setType(type);
        ingredient.setIds(new String[] {jsonObject.getString(type)});

        return ingredient;
    }

    public static MCIngredient build(JSONArray jsonArray) {
//        TODO: purpur_slab.json tiene 2 posibles items en vez de un tag
        MCIngredient ingredient = new MCIngredient();
        List<String> idList = new ArrayList<>();

        ingredient.setType("item");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            idList.add(json.getString("item"));
        }
        ingredient.setIds(idList.toArray(new String[0]));

        return ingredient;
    }
}
