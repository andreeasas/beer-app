package com.asas.beerapp.util;

import com.asas.beerapp.beerapp.api.JsonFavoriteBeer;

import java.time.LocalDate;

public class JsonSamples {

    public static final String defaultEmail = "joedoe@gmail.com";
    public static final String secondEmail = "joedoe2@gmail.com";
    public static final String thirdEmail = "joedoe3@gmail.com";

    public static JsonFavoriteBeer createJsonReviewNotDrunk(String email, long beerId){
        JsonFavoriteBeer jsonFavoriteBeer = new JsonFavoriteBeer();
        jsonFavoriteBeer.setUserEmail(email);
        jsonFavoriteBeer.setBeerId(beerId);
        jsonFavoriteBeer.setDrunkBefore(false);
        return jsonFavoriteBeer;
    }

    public static JsonFavoriteBeer createJsonReviewWithoutMandatoryFields(){
        return new JsonFavoriteBeer();
    }

    public static JsonFavoriteBeer createJsonReviewWithInconsistentData(String email, long beerId) {
        JsonFavoriteBeer jsonFavoriteBeer = new JsonFavoriteBeer();
        jsonFavoriteBeer.setUserEmail(email);
        jsonFavoriteBeer.setBeerId(beerId);
        jsonFavoriteBeer.setDrunkBefore(false);   // should give no details if never tasted
        jsonFavoriteBeer.setWhenTasted(LocalDate.of(2050, 1, 1)); // day in future
        jsonFavoriteBeer.setWhereTasted("UK");
        jsonFavoriteBeer.setTasteNote(0); // tasteNote out of allowed[min,max] values
        jsonFavoriteBeer.setComments("It was pretty ok for a dinner.");
        return jsonFavoriteBeer;
    }

    public static JsonFavoriteBeer createJsonReviewWithRating(String email, long beerId, int tasteNote) {
        JsonFavoriteBeer jsonFavoriteBeer = new JsonFavoriteBeer();
        jsonFavoriteBeer.setUserEmail(email);
        jsonFavoriteBeer.setBeerId(beerId);
        jsonFavoriteBeer.setDrunkBefore(true);
        jsonFavoriteBeer.setWhenTasted(LocalDate.now());
        jsonFavoriteBeer.setWhereTasted("UK");
        jsonFavoriteBeer.setTasteNote(tasteNote);
        jsonFavoriteBeer.setComments("It was pretty ok for a dinner.");
        return jsonFavoriteBeer;
    }

}
