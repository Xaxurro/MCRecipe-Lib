package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Recipe {
    String type;
    String item;
    int count = 1;

    public static Recipe build (File json, ObjectMapper om) throws IOException {
        Recipe recipe = new Recipe();

        JsonNode jsonNode = om.readTree(json);

        String type = jsonNode.findValue("type").asText();
        if (!type.equals("minecraft:crafting_shapeless")) {
            return null;
        }
        recipe.setType(type);

        JsonNode result = jsonNode.findValue("result");

        recipe.setItem(result.get("item").asText());
        if (result.has("count")){
            recipe.setCount(result.findValue("count").asInt());
        }

        return recipe;
    }

    public static Recipe build (File json) throws IOException {
        ObjectMapper om = new ObjectMapper();
        return Recipe.build(json, om);
    }

    public static List<Recipe> build (File[] jsons) throws IOException {
        List<Recipe> recipeList = new ArrayList<>();
        ObjectMapper om = new ObjectMapper();

        for (File json : jsons) {
            Recipe r = Recipe.build(json, om);
            if (r != null) recipeList.add(r);
        }
        return recipeList;
    }

}
