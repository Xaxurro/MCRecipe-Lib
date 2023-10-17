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
public class MCRecipeStonecutting implements MCRecipe{
    String name;
    String category;
    RecipeType type = RecipeType.stonecutting;

    public MCRecipeStonecutting (JSONObject json){

    }

    @Override
    public File generateJSON(File outputFile) throws IOException {
        return null;
    }
}