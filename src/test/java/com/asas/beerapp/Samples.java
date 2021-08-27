package com.asas.beerapp;

import com.asas.beerapp.model.BeerReview;

public class Samples {

    public static final long defaultBeerId=1;

    public static final String defaultEmail = "joedoe@gmail.com";
    public static final String secondEmail = "joedoe2@gmail.com";
    public static final String thirdEmail = "joedoe3@gmail.com";

    public static final int defaultTasteNote = 4;

    public static BeerReview createDefaultReview() {
        BeerReview beerReview = new BeerReview();
        beerReview.setUserEmail(defaultEmail);
        beerReview.setBeerId(defaultBeerId);
        beerReview.setDrunkBefore(true);
//        beerReview.setWhen(ZonedDateTime.now());
        beerReview.setWhere("UK");
        beerReview.setTasteNote(4);
        beerReview.setComments("It was pretty ok for a dinner.");
        return beerReview;
    }

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
//        beerReview.setWhen(ZonedDateTime.now());
        beerReview.setWhere("UK");
        beerReview.setTasteNote(tasteNote);
        beerReview.setComments("It was pretty ok for a dinner.");
        return beerReview;
    }

    public static BeerReview createReviewDrunk(String email, long beerId) {
        BeerReview beerReview = createReviewWithRating(email, beerId, defaultTasteNote);
        return beerReview;
    }

}
