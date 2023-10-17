package recipes;

import org.junit.jupiter.api.Test;
import org.xaxurro.recipe.MCRecipeException;
import org.xaxurro.recipe.properties.MCResult;
import org.xaxurro.recipe.properties.MCShape;
import org.xaxurro.recipe.types.MCRecipeShaped;

import java.io.IOException;

public class JSONSTests {
    @Test
    void shaped() throws MCRecipeException, IOException {
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
        recipe.setCategory("equipment");
        recipe.setGroup("diamond_pickaxe");
        recipe.setNotification(true);

        recipe.generateJSON("diamond_pickaxe_custom.json");
    }
}
