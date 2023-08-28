package org.xaxurro.classes.recipe.types;

import lombok.*;
import org.json.JSONObject;
import org.xaxurro.enums.RecipeType;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCRecipeBlasting implements MCRecipe{
    String name;
    String category;
    RecipeType type = RecipeType.blasting;

    public MCRecipeBlasting(JSONObject json){

    }
}
