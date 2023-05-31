package org.example.classes.recipeTypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.example.classes.MCIngredient;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeShapeless extends MCRecipe{
    String type = "minecraft:crafting_shapeless";
    MCIngredient[] ingredients;
    MCIngredient item;
    int count;

    public static MCRecipeShapeless build(JsonNode json, ObjectMapper om) throws JsonProcessingException {
        MCRecipeShapeless recipe = new MCRecipeShapeless();

        JsonNode value = json.findValue("ingredients");

        return recipe;
    }
}
