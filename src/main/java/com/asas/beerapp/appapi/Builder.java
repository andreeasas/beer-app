package com.asas.beerapp.appapi;

import com.asas.beerapp.model.BeerReview;
import com.asas.beerapp.punkapi.JsonBeer;

public class Builder {

    public static BeerReview buildBeerReview(JsonReview jsonReview) {
        BeerReview beerReview = new BeerReview();
        beerReview.setUserEmail(jsonReview.getUserEmail());
        beerReview.setBeerId(jsonReview.getBeerId());
        beerReview.setDrunkBefore(jsonReview.isDrunkBefore());
        beerReview.setWhere(jsonReview.getWhereTasted());
        beerReview.setWhen(jsonReview.getWhenTasted());
        beerReview.setTasteNote(jsonReview.getTasteNote());
        beerReview.setComments(jsonReview.getComments());
        return beerReview;
    }

    public static JsonFavoriteBeer buildFavoriteBeer(BeerReview beerReview, JsonBeer jsonBeer) {
        JsonFavoriteBeer jsonFavoriteBeer = JsonFavoriteBeer.builder()
                .jsonReview(JsonReview.builder()
                        .id(beerReview.getId())
                        .userEmail(beerReview.getUserEmail())
                        .beerId(beerReview.getBeerId())
                        .drunkBefore(beerReview.isDrunkBefore())
                        .whereTasted(beerReview.getWhere())
                        .whenTasted(beerReview.getWhen())
                        .tasteNote(beerReview.getTasteNote())
                        .comments(beerReview.getComments())
                        .build())
                .jsonBeerDetails(JsonBeerDetails.builder()
                        .id(jsonBeer.getId())
                        .name(jsonBeer.getName())
                        .description(jsonBeer.getDescription())
                        .imageUrl(jsonBeer.getImageUrl())
                        .foodPairings(jsonBeer.getFoodPairings())
                        .build())
                .build();

        assert jsonFavoriteBeer.getJsonBeerDetails().getId() >0;
        assert  jsonFavoriteBeer.getJsonReview().getUserEmail() !=null;

        return jsonFavoriteBeer;
    }
}
