package org.example.recipes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

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
    Map<String, String> keys;
    String[] pattern;

//    Look at beacon.json for reference
    public static MCRecipeShaped build(JsonNode json, ObjectMapper om) throws JsonProcessingException {
        MCRecipeShaped recipe = new MCRecipeShaped();

        String[] pattern = om.readValue(json.findValue("pattern").toString(), String[].class);
        recipe.setPattern(pattern);

        Map<String, String> keys = new HashMap<>();
        Iterator<Map.Entry<String, JsonNode>> fields = json.findValue("key").fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String K = field.getKey();
            String V = field.getValue().findValue("item").asText();
            keys.put(K, V);
        }
        recipe.setKeys(keys);
//        recipe.setKeys(om.readValue(.toString(), String[].class));

        JsonNode result = json.findValue("result");
        recipe.setItem(result.findValue("item").asText());
        if (result.has("count")){
            recipe.setCount(result.findValue("count").asInt(1));
        }

        return recipe;
    }
}
