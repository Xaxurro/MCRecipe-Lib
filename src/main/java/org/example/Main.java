package org.example;

import com.fasterxml.jackson.core.JsonParser;
import netscape.javascript.JSObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File[] files = new File("src/main/resources/Minecraft-Recipes").listFiles();

        List<Recipe> recipeList = Recipe.build(files);
        System.out.println(recipeList);
    }
}