package com.asas.beerapp.beerapp.api;

import com.asas.beerapp.model.FavoriteBeer;
import com.asas.beerapp.punkapi.JsonBeer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Mapper {

    public static JsonFavoriteBeerResponse buildFavoriteBeerResponse(FavoriteBeer favoriteBeer, JsonBeer jsonBeer) {
        JsonFavoriteBeerResponse jsonFavoriteBeerResponse = JsonFavoriteBeerResponse.builder()
                .jsonFavoriteBeer(JsonFavoriteBeer.builder()
                        .id(favoriteBeer.getId())
                        .userEmail(favoriteBeer.getUserEmail())
                        .beerId(favoriteBeer.getBeerId())
                        .drunkBefore(favoriteBeer.isDrunkBefore())
                        .whereTasted(favoriteBeer.getWhere())
                        .whenTasted(favoriteBeer.getWhen())
                        .tasteNote(favoriteBeer.getTasteNote())
                        .comments(favoriteBeer.getComments())
                        .build())
                .jsonBeerDetails(JsonBeerDetails.builder()
                        .id(jsonBeer.getId())
                        .name(jsonBeer.getName())
                        .description(jsonBeer.getDescription())
                        .imageUrl(jsonBeer.getImageUrl())
                        .foodPairings(jsonBeer.getFoodPairings())
                        .build())
                .build();

        assert jsonFavoriteBeerResponse.getJsonBeerDetails().getId() >0;
        assert  jsonFavoriteBeerResponse.getJsonFavoriteBeer().getUserEmail() !=null;

        return jsonFavoriteBeerResponse;
    }
}
