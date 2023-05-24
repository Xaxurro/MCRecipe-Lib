package org.example;

import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Ingredient {
    String name;

    public Ingredient(String name){
        this.name = "minecraft:" + name;
    }
}
