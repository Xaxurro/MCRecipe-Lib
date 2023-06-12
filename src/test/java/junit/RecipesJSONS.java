package junit;

import org.example.classes.MCIngredient;
import org.example.classes.recipeTypes.MCRecipe;
import org.example.classes.recipeTypes.MCRecipeShaped;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecipesJSONS {

    File fileBlastingRecipe;
    File fileCampfireRecipe;
    File fileShapedRecipe;
    File filePurpurSlabRecipe;
    File fileShapelessRecipe;
    File fileSmeltingRecipe;
    File fileSmithingRecipe;
    File fileSmokingRecipe;
    File fileStonecuttingRecipe;

    @Before
    public void initFiles() {
        fileBlastingRecipe = getFile("iron_ingot_from_blasting_iron_ore");
        fileCampfireRecipe = getFile("baked_potato_from_campfire_cooking");
        fileShapedRecipe = getFile("diamond_pickaxe");
        filePurpurSlabRecipe = getFile("purpur_slab");
        fileShapelessRecipe = getFile("acacia_button");
        fileSmeltingRecipe = getFile("green_dye");
        fileSmithingRecipe = getFile("netherite_chestplate_smithing");
        fileSmokingRecipe = getFile("baked_potato_from_smoking");
        fileStonecuttingRecipe = getFile("andesite_slab_from_andesite_stonecutting");
    }

    private File getFile(String recipeName) {
        final String rootPath = "src/main/resources/Minecraft-Recipes";
        return new File(rootPath + '/' + recipeName + ".json");
    }

    @Test
    public void recipeShaped() throws IOException {
        MCIngredient diamond = new MCIngredient("minecraft:diamond");
        MCIngredient stick = new MCIngredient("minecraft:stick");
        MCIngredient string = new MCIngredient("minecraft:string");

        MCIngredient diamondPickaxe = new MCIngredient("minecraft:diamond_pickaxe");

        MCRecipeShaped diamondPickaxeAlt = new MCRecipeShaped();
        diamondPickaxeAlt.setItem(diamondPickaxe);

        String[] pattern = new String[] {
                "XXX",
                " # ",
                " # "
        };
        diamondPickaxeAlt.setPattern(pattern);

        Map<String, MCIngredient> keys = new HashMap<>();
        keys.put("X", diamond);
        keys.put("#", stick);
        diamondPickaxeAlt.setKeys(keys);

        diamondPickaxeAlt.createJSON("diamond_pickaxe_alt.json");

//        TODO: Verificar que los archivos sean iguales
    }

    @Test
    public void purpurSlab() throws IOException {
//        MCRecipeShaped recipe = (MCRecipeShaped) MCRecipe.build(getFile("purpur_slab"));
        MCRecipeShaped recipe = (MCRecipeShaped) MCRecipe.build(getFile("beacon"));
        System.out.println(recipe.getIngredients());
    }
}
