package com.asas.beerapp.util;

import com.asas.beerapp.model.FavoriteBeer;

public class BeerReviewSamples {

    public static final long defaultBeerId=1;

    public static final String defaultEmail = "joedoe@gmail.com";
    public static final String secondEmail = "joedoe2@gmail.com";
    public static final String thirdEmail = "joedoe3@gmail.com";

    public static final int defaultTasteNote = 4;

    public static FavoriteBeer createReviewNotDrunk(String email, long beerId) {
        FavoriteBeer favoriteBeer = new FavoriteBeer();
        favoriteBeer.setUserEmail(email);
        favoriteBeer.setBeerId(beerId);
        favoriteBeer.setDrunkBefore(false);
        return favoriteBeer;
    }

    public static FavoriteBeer createReviewWithRating(String email, long beerId, int tasteNote) {
        FavoriteBeer favoriteBeer = new FavoriteBeer();
        favoriteBeer.setUserEmail(email);
        favoriteBeer.setBeerId(beerId);
        favoriteBeer.setDrunkBefore(true);
//        beerReview.setWhen(LocalDate.now());
        favoriteBeer.setWhere("UK");
        favoriteBeer.setTasteNote(tasteNote);
        favoriteBeer.setComments("It was pretty ok for a dinner.");
        return favoriteBeer;
    }

}
