package org.example.classes.recipeTypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.example.classes.MCIngredient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeShaped extends MCRecipe{
    String type = "minecraft:crafting_shaped";
    Map<String, MCIngredient[]> keys;
    String[] pattern;
    MCIngredient item;
    int count;

//    Look at beacon.json for reference
    public static MCRecipeShaped build(JsonNode json, ObjectMapper om) throws JsonProcessingException {
        MCRecipeShaped recipe = new MCRecipeShaped();

        String[] pattern = om.readValue(json.findValue("pattern").toString(), String[].class);
        recipe.setPattern(pattern);

        Map<String, MCIngredient[]> keys = new HashMap<>();
        Iterator<Map.Entry<String, JsonNode>> fields = json.findValue("key").fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String K = field.getKey();
            MCIngredient[] V = MCIngredient.build(field.getValue());
            keys.put(K, V);
        }
        recipe.setKeys(keys);

        JsonNode result = json.findValue("result");
        MCIngredient item = new MCIngredient(result.findValue("item").asText(), "item");
        recipe.setItem(item);
        if (result.has("count")){
            recipe.setCount(result.findValue("count").asInt(1));
        }

        return recipe;
    }
}
