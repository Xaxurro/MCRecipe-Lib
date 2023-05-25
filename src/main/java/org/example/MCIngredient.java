package org.example;

import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class MCIngredient {
    String name;

    public MCIngredient(String name){
        this.name = "minecraft:" + name;
    }
}
