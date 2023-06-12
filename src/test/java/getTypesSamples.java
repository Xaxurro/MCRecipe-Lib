import org.example.classes.recipeTypes.MCRecipe;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class getTypesSamples {
    public static void main(String[] args) throws IOException {
        final String path = "src/main/resources/Minecraft-Recipes";
        File[] files = new File(path).listFiles();

        Set<String> typeSet = new HashSet<>();

        for (File file : files) {
            MCRecipe recipe = MCRecipe.build(file);
            String type = recipe.getType();
            if (typeSet.contains(type)){
                continue;
            }

            typeSet.add(type);
            System.out.println(type);
            System.out.println(file.getAbsolutePath() + "\n");
        }
    }
}
