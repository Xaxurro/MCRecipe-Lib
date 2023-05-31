package org.example.classes;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCIngredient {
    String id;
    String type;

    public static MCIngredient[] build(JsonNode json) {
//        TODO: purpur_slab.json tiene 2 posibles items en vez de un tag
        MCIngredient ingredient = new MCIngredient();
        String type = (json.has("item") ? "item" : "tag");
        ingredient.setType(type);
        ingredient.setId(json.findValue(type).asText());

//        return ingredient;
        return null;
    }
}
