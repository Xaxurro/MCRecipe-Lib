package recipes;

import org.junit.jupiter.api.Assertions;
import org.xaxurro.classes.recipe.properties.MCIngredient;
import org.xaxurro.classes.recipe.properties.MCShape;
import org.xaxurro.classes.recipe.properties.MCResult;
import org.xaxurro.classes.recipe.types.MCRecipeShaped;
import org.xaxurro.enums.IngredientType;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapedTests {
    @Test
    public void loadRecipe() throws IOException {
        MCRecipeShaped recipe = MCRecipeShaped.buildFromFile(RecipeTestUtils.SHAPED_RECIPE_FILE);

        String[] pattern = recipe.getShape().getPattern();
        Assertions.assertEquals("XXX", pattern[0]);
        Assertions.assertEquals(" # ", pattern[1]);
        Assertions.assertEquals(" # ", pattern[2]);

        List<MCIngredient> ingredients = recipe.getIngredients();
        Assertions.assertEquals("minecraft:diamond", ingredients.get(1).getId());
        Assertions.assertEquals(IngredientType.Item, ingredients.get(1).getIngredientType());

        MCResult result = recipe.getResult();
        Assertions.assertEquals("minecraft:diamond_pickaxe", result.getId());
        Assertions.assertEquals(1, result.getCount());
    }

    @Test
    public void succesfullRecipeCreation() {
        MCRecipeShaped recipe = new MCRecipeShaped();

        MCShape shape = new MCShape();
        String[] pattern = new String[]{
            "XSX",
            " # ",
            " # "
        };

        shape.addItem("X", "diamond");
        shape.addItem("S", "string");
        shape.addItem("#", "stick");

        shape.setPattern(pattern);

        recipe.setShape(shape);

        recipe.setResult(new MCResult("diamond_pickaxe"));
    }

    @Test
    public void purpurSlabParse() throws IOException {
        File purpurSlabFile = RecipeTestUtils.getRecipeFile("purpur_slab");
        MCRecipeShaped purpurSlab = MCRecipeShaped.buildFromFile(purpurSlabFile);
        Assertions.assertEquals(new MCIngredient("purpur_block"), purpurSlab.getIngredients().get(0));
        Assertions.assertEquals(new MCIngredient("purpur_pillar"), purpurSlab.getIngredients().get(1));
    }
}
