package org.xaxurro.classes.recipe.types;

import lombok.*;
import org.json.JSONObject;
import org.xaxurro.enums.RecipeType;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeSmelting implements MCRecipe{
    String name;
    String category;
    RecipeType type = RecipeType.smelting;

    public MCRecipeSmelting(JSONObject json){

    }
}