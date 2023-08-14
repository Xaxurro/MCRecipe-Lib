package recipes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecipeTestUtils {

    static final File BLASTING_RECIPE_FILE = getRecipeFile("iron_ingot_from_blasting_iron_ore");
    static final File CAMPFIRE_RECIPE_FILE = getRecipeFile("baked_potato_from_campfire_cooking");
    static final File SHAPED_RECIPE_FILE = getRecipeFile("diamond_pickaxe");
    static final File SHAPELESS_RECIPE_FILE = getRecipeFile("acacia_button");
    static final File SMELTING_RECIPE_FILE = getRecipeFile("green_dye");
    static final File SMITHING_RECIPE_FILE = getRecipeFile("netherite_chestplate_smithing");
    static final File SMOKING_RECIPE_FILE = getRecipeFile("baked_potato_from_smoking");
    static final File STONECUTTING_RECIPE_FILE = getRecipeFile("andesite_slab_from_andesite_stonecutting");

    public static File getRecipeFile(String recipeName) {
        final String rootPath = "src/main/resources/Minecraft-Recipes";
        return new File(rootPath + '/' + recipeName + ".json");
    }

    public static File[] getRecipeFile(String... recipeNames) {
        final String rootPath = "src/main/resources/Minecraft-Recipes";
        final List<File> recipes = new ArrayList<>();

        for (String file : recipeNames) {
            recipes.add(getRecipeFile(file));
        }
        return recipes.toArray(new File[0]);
    }
}
