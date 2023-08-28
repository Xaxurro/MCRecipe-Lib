package org.xaxurro.classes.recipe.types;


import lombok.*;
import org.json.JSONObject;
import org.xaxurro.enums.RecipeType;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeCampfireCooking implements MCRecipe{
    String name;
    String category;
    RecipeType type = RecipeType.campfire_cooking;

    public MCRecipeCampfireCooking(JSONObject json){

    }
}
