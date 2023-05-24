package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File[] files = new File("src/main/resources/Minecraft-Recipes").listFiles();

//        List<Recipe> recipeList = Recipe.build(files);
//        System.out.println(recipeList);

        ObjectMapper om = new ObjectMapper();
        List<String> types = new ArrayList<>();

        for (File f : files) {
            JsonNode jsonNode = om.readTree(f);
            String type = jsonNode.findValue("type").asText();
            if (!types.contains(type)) {
                System.out.println(f.getAbsolutePath());
                System.out.println(type + "\n");
                types.add(type);
            }
        }

        System.out.println("\n\n\n\n\n");
        types.forEach(System.out::println);
        System.out.println(types.size());
    }
}