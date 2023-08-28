package org.xaxurro.classes.recipe.types;

import lombok.*;
import org.json.JSONObject;
import org.xaxurro.enums.RecipeType;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeSmithing implements MCRecipe{
    String name;
    String category;
    RecipeType type = RecipeType.smithing_trim;

    public MCRecipeSmithing (JSONObject json){

    }
}