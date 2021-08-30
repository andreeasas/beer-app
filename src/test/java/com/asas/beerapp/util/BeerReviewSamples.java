package com.asas.beerapp.util;

import com.asas.beerapp.model.BeerReview;

import java.time.LocalDate;

public class BeerReviewSamples {

    public static final long defaultBeerId=1;

    public static final String defaultEmail = "joedoe@gmail.com";
    public static final String secondEmail = "joedoe2@gmail.com";
    public static final String thirdEmail = "joedoe3@gmail.com";

    public static final int defaultTasteNote = 4;

    public static BeerReview createReviewNotDrunk(String email, long beerId) {
        BeerReview beerReview = new BeerReview();
        beerReview.setUserEmail(email);
        beerReview.setBeerId(beerId);
        beerReview.setDrunkBefore(false);
        return beerReview;
    }

    public static BeerReview createReviewWithRating(String email, long beerId, int tasteNote) {
        BeerReview beerReview = new BeerReview();
        beerReview.setUserEmail(email);
        beerReview.setBeerId(beerId);
        beerReview.setDrunkBefore(true);
//        beerReview.setWhen(LocalDate.now());
        beerReview.setWhere("UK");
        beerReview.setTasteNote(tasteNote);
        beerReview.setComments("It was pretty ok for a dinner.");
        return beerReview;
    }

}
