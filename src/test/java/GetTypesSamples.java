import org.xaxurro.recipe.MCRecipeException;
import org.xaxurro.recipe.MCRecipeFactory;
import org.xaxurro.recipe.types.MCRecipe;
import org.xaxurro.enums.RecipeType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GetTypesSamples {
    public static void main(String[] args) throws IOException, MCRecipeException {
        final String path = "src/main/resources/Minecraft-Recipes";
        File[] files = new File(path).listFiles();



//        Obtener types
        Map<RecipeType, List<String>> samples = getSamples(20, files);

        writeFile(samples);

//        System.out.println(type);
//        System.out.println(file.getAbsolutePath() + "\n");
    }

    private static Map<RecipeType, List<String>> getSamples(int maxSamples, File[] files) throws IOException, MCRecipeException {
        Map<RecipeType, List<String>> typeMap = new HashMap();

        for (File file : files) {
            MCRecipe recipe = MCRecipeFactory.buildFromFile(file);

            RecipeType type = recipe.getType();
            String example = file.getPath();

            if (!typeMap.containsKey(type)) {
                typeMap.put(type, new ArrayList<>(Arrays.asList(example)));
            } else if (maxSamples != 0 && typeMap.get(type).size() < maxSamples){
                typeMap.get(type).add(example);
            }
        }

        return typeMap;
    }

    private static void writeFile(Map<RecipeType, List<String>> typeListMap) throws IOException {
        File o = new File("recipe_samples.txt");
        o.createNewFile();
        FileWriter fw = new FileWriter(o);

        for (Map.Entry<RecipeType, List<String>> type : typeListMap.entrySet()) {
            fw.write("\n" + type.getKey() + "\n");
            for (String sample : type.getValue()) {
                fw.write("/home/xaxurro/Progra/Xaxurro-Recipe-lib/" + sample + "\n");
            }
        }
    }
}
