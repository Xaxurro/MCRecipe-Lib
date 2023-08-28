package org.xaxurro.classes.recipe.types;

import lombok.*;
import org.json.JSONObject;
import org.xaxurro.enums.RecipeType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public interface MCRecipe {

//    String name;
//    RecipeType type;
//    String category;
//    Ingredients | Items

//
//    Build Methods
//
    void setName(String name);
    String getName();
    void setType(RecipeType type);
    RecipeType getType();
    void setCategory(String category);
    String getCategory();

//    TODO hacer que cuando se quiera escribir el archivo que verifique si la longitud del array es 1
//    TODO hacer que cada subclase tengo su propio metodo generateJsonFile, considerar usar interfaz

//
//    generateJSON Methods
//
    default public File generateJSON(File outputFile) throws IOException{
        FileWriter fw = new FileWriter(outputFile);
        String json = new JSONObject(this).toString(2);
        fw.write(json);
        fw.close();
        return outputFile;
    }

    default public File generateJSON(String outputFileName) throws IOException {
        return generateJSON(new File(outputFileName));
    }
}
