package recipes;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.xaxurro.classes.MCRecipeException;
import org.xaxurro.classes.recipe.MCRecipeFactory;
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
    public void loadRecipe() throws IOException, MCRecipeException {
        MCRecipeShaped recipe = (MCRecipeShaped) MCRecipeFactory.buildFromFile(RecipeTestUtils.SHAPED_RECIPE_FILE);

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
    public void succesfullRecipeCreation() throws MCRecipeException {
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
    public void shapeExceptions() {
        MCRecipeShaped recipe = new MCRecipeShaped();
        MCShape shape = new MCShape();

        Assert.assertThrows(MCRecipeException.class, () -> {
            recipe.setShape(shape);
        });

        String[] pattern = new String[]{
                "XSX",
                " # ",
                " # "
        };
        shape.setPattern(pattern);

        Assert.assertThrows(MCRecipeException.class, () -> {
            recipe.setShape(shape);
        });

        shape.setPattern(null);
        shape.addItem("X", "diamond");
        shape.addItem("S", "string");
        shape.addItem("#", "stick");

        Assert.assertThrows(MCRecipeException.class, () -> {
            recipe.setShape(shape);
        });

        shape.setPattern(pattern);
        shape.setKeys(null);
        shape.addItem("X", "diamond");
        shape.addItem("S", "string");

        Assert.assertThrows(MCRecipeException.class, () -> {
            recipe.setShape(shape);
        });
    }

    @Test
    public void purpurSlabParse() throws IOException, MCRecipeException {
        File purpurSlabFile = RecipeTestUtils.getRecipeFile("purpur_slab");
        MCRecipeShaped purpurSlab = (MCRecipeShaped) MCRecipeFactory.buildFromFile(purpurSlabFile);
        Assertions.assertEquals(new MCIngredient("purpur_block"), purpurSlab.getIngredients().get(0));
        Assertions.assertEquals(new MCIngredient("purpur_pillar"), purpurSlab.getIngredients().get(1));
    }
}
