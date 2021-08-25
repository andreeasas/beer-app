package com.asas.beerapp.punkapi;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonIngredients {

    @Singular("malt")
    private List<JsonIngredient> malt;
    @Singular("hops")
    private List<JsonIngredient> hops;
    private String yeast;

}

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
class JsonIngredient {

    private String name;
}
