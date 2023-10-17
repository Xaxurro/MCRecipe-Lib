package org.xaxurro.enums;

public enum IngredientType {
    Item("item"),
    Tag("tag");

    String name;
    IngredientType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}