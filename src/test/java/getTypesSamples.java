import org.xaxurro.classes.recipe.types.MCRecipe;
import org.xaxurro.enums.RecipeType;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class getTypesSamples {
    public static void main(String[] args) throws IOException {
        final String path = "src/main/resources/Minecraft-Recipes";
        File[] files = new File(path).listFiles();

        Map<RecipeType, List<String>> typeMap = new HashMap();

        final int MAX_SAMPLES = 10;

//        Obtener types
        for (File file : files) {
            MCRecipe recipe = MCRecipe.build(file);

            RecipeType type = recipe.getType();
            String example = file.getPath();

            if (!typeMap.containsKey(type)) {
                typeMap.put(type, new ArrayList<>(Arrays.asList(example)));
            } else if (MAX_SAMPLES != 0 && typeMap.get(type).size() < MAX_SAMPLES){
                typeMap.get(type).add(example);
            }
        }

        for (Map.Entry<RecipeType, List<String>> type : typeMap.entrySet()) {
            System.out.println("\n" + type.getKey());
            for (String example : type.getValue()) {
                System.out.println("/home/xaxurro/Progra/Xaxurro-Recipe-lib/" + example);
            }
        }

//        System.out.println(type);
//        System.out.println(file.getAbsolutePath() + "\n");
    }
}
