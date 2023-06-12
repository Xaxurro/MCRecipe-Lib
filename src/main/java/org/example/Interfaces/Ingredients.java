package org.example.Interfaces;

import org.example.classes.MCIngredient;

import java.util.Map;

public interface Ingredients {
    default MCIngredient[] getIngredients(Map<String, MCIngredient> keys) {
        if(keys.isEmpty()) {
            return null;
        }
        return (MCIngredient[]) keys.values().toArray();
    }
}
