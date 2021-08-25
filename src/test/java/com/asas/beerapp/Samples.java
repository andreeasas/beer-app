package com.asas.beerapp;

import com.asas.beerapp.model.Beer;

import java.util.ArrayList;
import java.util.Calendar;

public class Samples {

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

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2007);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        beer.setFirstBrewed(calendar.getTime());

        ArrayList<String> foodPairing = new ArrayList<>();
        foodPairing.add("Spicy carne asada with a pico de gallo sauce");
        foodPairing.add("Shredded chicken tacos with a mango chilli lime salsa");
        foodPairing.add("Cheesecake with a passion fruit swirl sauce");
        beer.setFoodPairing(foodPairing);
    }
}
