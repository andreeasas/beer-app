package com.asas.beerapp.beerapp.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonFavoriteBeer {

    private JsonReview jsonReview;
    private JsonBeerDetails jsonBeerDetails;
}