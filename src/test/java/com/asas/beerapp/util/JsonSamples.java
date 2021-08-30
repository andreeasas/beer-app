package com.asas.beerapp.util;

import com.asas.beerapp.beerapp.api.JsonReview;

import java.time.LocalDate;

public class JsonSamples {

    public static final String defaultEmail = "joedoe@gmail.com";
    public static final String secondEmail = "joedoe2@gmail.com";
    public static final String thirdEmail = "joedoe3@gmail.com";

    public static JsonReview createJsonReviewNotDrunk(String email, long beerId){
        JsonReview jsonReview = new JsonReview();
        jsonReview.setUserEmail(email);
        jsonReview.setBeerId(beerId);
        jsonReview.setDrunkBefore(false);
        return jsonReview;
    }

    public static JsonReview createJsonReviewWithoutMandatoryFields(){
        return new JsonReview();
    }

    public static JsonReview createJsonReviewWithInconsistentData(String email, long beerId) {
        JsonReview jsonReview = new JsonReview();
        jsonReview.setUserEmail(email);
        jsonReview.setBeerId(beerId);
        jsonReview.setDrunkBefore(false);   // should give no details if never tasted
        jsonReview.setWhenTasted(LocalDate.of(2050, 1, 1)); // day in future
        jsonReview.setWhereTasted("UK");
        jsonReview.setTasteNote(0); // tasteNote out of allowed[min,max] values
        jsonReview.setComments("It was pretty ok for a dinner.");
        return jsonReview;
    }

    public static JsonReview createJsonReviewWithRating(String email, long beerId, int tasteNote) {
        JsonReview jsonReview = new JsonReview();
        jsonReview.setUserEmail(email);
        jsonReview.setBeerId(beerId);
        jsonReview.setDrunkBefore(true);
        jsonReview.setWhenTasted(LocalDate.now());
        jsonReview.setWhereTasted("UK");
        jsonReview.setTasteNote(tasteNote);
        jsonReview.setComments("It was pretty ok for a dinner.");
        return jsonReview;
    }

}
