package com.asas.beerapp.punkapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonBeer {

    private long id;
    private String name;
    private String tagline;
    private String description;
    private String imageUrl;

    private float abv;
    private int ibu;
    private float targetFg;
    private float targetOg;
    private float ebc;
//    private float srm;
//    private float ph;
//    private float attenuationLevel;

//    private JsonIngredients ingredients;
    @Singular
    @JsonProperty("food_pairing")
    private List<String> foodPairings;

}
