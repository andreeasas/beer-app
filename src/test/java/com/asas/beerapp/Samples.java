package com.asas.beerapp;

import com.asas.beerapp.model.Beer;
import com.asas.beerapp.model.BeerReview;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Samples {

    public static final String defaultEmail="joedoe@gmail.com";
    public static final String secondEmail="joedoe2@gmail.com";

    public static BeerReview createDefaultReview() {
        BeerReview beerReview = new BeerReview();
        beerReview.setUserEmail(defaultEmail);
        beerReview.setDrunkBefore(true);
        beerReview.setWhen(ZonedDateTime.now());
        beerReview.setWhere("UK");
        beerReview.setTasteNote(4);
        beerReview.setComments("It was pretty ok for a dinner.");
        return beerReview;
    }

    public static BeerReview createReviewNotDrunk(String email, int beerId) {
        BeerReview beerReview = new BeerReview();
        beerReview.setUserEmail(email);
        beerReview.setDrunkBefore(false);
        return beerReview;
    }

    public static BeerReview createReviewDrunk(String email, int beerId) {
        BeerReview beerReview = new BeerReview();
        beerReview.setUserEmail(email);
        beerReview.setDrunkBefore(true);
        beerReview.setWhen(ZonedDateTime.now());
        beerReview.setWhere("UK");
        beerReview.setTasteNote(4);
        beerReview.setComments("It was pretty ok for a dinner.");
        return beerReview;
    }

    public static Beer createBeerSample(){
        Beer beer = new Beer();
        setTestValues(beer);
        return beer;
    }

    public static Beer createBeerSample(long id) {
        Beer beer = new Beer(id);
        setTestValues(beer);
        return beer;
    }

    private static void setTestValues(Beer beer) {
        beer.setName("Punk IPA 2007 - 2010");
        beer.setAbv(6.0f);
        beer.setIbu(60);
        beer.setEbc(24.5f);

        ArrayList<String> foodPairing = new ArrayList<>();
        foodPairing.add("Spicy carne asada with a pico de gallo sauce");
        foodPairing.add("Shredded chicken tacos with a mango chilli lime salsa");
        foodPairing.add("Cheesecake with a passion fruit swirl sauce");
        beer.setFoodPairing(foodPairing);
    }
}
