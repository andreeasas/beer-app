package com.asas.beerapp.beerapp.api;

import com.asas.beerapp.model.FavoriteBeer;
import com.asas.beerapp.punkapi.JsonBeer;

public class Builder {

    public static FavoriteBeer buildBeerReview(JsonFavoriteBeer jsonFavoriteBeer) {
        FavoriteBeer favoriteBeer = new FavoriteBeer();
        favoriteBeer.setUserEmail(jsonFavoriteBeer.getUserEmail());
        favoriteBeer.setBeerId(jsonFavoriteBeer.getBeerId());
        favoriteBeer.setDrunkBefore(jsonFavoriteBeer.isDrunkBefore());
        favoriteBeer.setWhere(jsonFavoriteBeer.getWhereTasted());
        favoriteBeer.setWhen(jsonFavoriteBeer.getWhenTasted());
        favoriteBeer.setTasteNote(jsonFavoriteBeer.getTasteNote());
        favoriteBeer.setComments(jsonFavoriteBeer.getComments());
        return favoriteBeer;
    }

    public static JsonFavoriteBeerResponse buildFavoriteBeer(FavoriteBeer favoriteBeer, JsonBeer jsonBeer) {
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
