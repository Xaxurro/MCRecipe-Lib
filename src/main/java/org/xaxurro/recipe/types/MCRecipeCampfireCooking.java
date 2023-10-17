package org.xaxurro.recipe.types;


import lombok.*;
import org.json.JSONObject;
import org.xaxurro.enums.RecipeType;

import java.io.File;
import java.io.IOException;

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

    @Override
    public File generateJSON(File outputFile) throws IOException {
        return null;
    }
}
