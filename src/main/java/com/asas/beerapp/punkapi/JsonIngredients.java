package com.asas.beerapp.punkapi;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Builder
@Data
public class JsonIngredients {

    public JsonIngredients() {
    }

    public JsonIngredients(List<JsonIngredient> malt, List<JsonIngredient> hops, String yeast) {
        this.malt = malt;
        this.hops = hops;
        this.yeast = yeast;
    }

    @Singular("malt")
    private List<JsonIngredient> malt;
    @Singular("hops")
    private List<JsonIngredient> hops;
    private String yeast;

}

@Builder
@Data
class JsonIngredient {

    public JsonIngredient() {
    }

    public JsonIngredient(String name) {
        this.name = name;
    }

    private String name;
//    private JsonAmount amount;
//    private String add;
//    private String attribute;
}

class JsonAmount {
    private float value;
    private String unit;
}
