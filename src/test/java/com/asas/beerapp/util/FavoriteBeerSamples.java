package com.asas.beerapp.util;

import com.asas.beerapp.model.FavoriteBeer;

public class FavoriteBeerSamples {

    public static final long defaultBeerId=1;

    public static final String defaultEmail = "joedoe@gmail.com";
    public static final String secondEmail = "joedoe2@gmail.com";
    public static final String thirdEmail = "joedoe3@gmail.com";

    public static final int defaultTasteNote = 4;

    public static FavoriteBeer createReviewNotDrunk(String email, long beerId) {
        return FavoriteBeer.builder()
                .userEmail(email)
                .beerId(beerId)
                .drunkBefore(false)
                .build();
    }

    public static FavoriteBeer createReviewWithRating(String email, long beerId, int tasteNote) {
        return FavoriteBeer.builder()
                .userEmail(email)
                .beerId(beerId)
                .drunkBefore(true)
                .where("UK")
//                .when(LocalDate.now())
                .tasteNote(tasteNote)
                .comments("It was pretty ok for a dinner.")
                .build();
    }

}
