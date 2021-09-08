package com.asas.beerapp.util;

import com.asas.beerapp.beerapp.api.JsonFavoriteBeer;

import java.time.LocalDate;

public class JsonFavoriteBeerSamples {

    public static final String defaultEmail = "joedoe@gmail.com";
    public static final String secondEmail = "joedoe2@gmail.com";
    public static final String thirdEmail = "joedoe3@gmail.com";

    public static JsonFavoriteBeer createJsonFavoriteBeerNotDrunk(String email, long beerId){
        return JsonFavoriteBeer.builder()
                .userEmail(email)
                .beerId(beerId)
                .drunkBefore(false)
                .build();
    }

    public static JsonFavoriteBeer createJsonFavoriteBeerWithoutMandatoryFields(){
        return JsonFavoriteBeer.builder().build();
    }

    public static JsonFavoriteBeer createJsonFavoriteBeerWithInconsistentData(String email, long beerId) {
        return JsonFavoriteBeer.builder()
                .userEmail(email)
                .beerId(beerId)
                .drunkBefore(false) // should give no details if never tasted
                .whereTasted("UK")
                .whenTasted(LocalDate.of(2050, 1, 1)) // day in future
                .tasteNote(0) // tasteNote out of allowed[min,max] values
                .comments("It was pretty ok for a dinner.")
                .build();
    }

    public static JsonFavoriteBeer createJsonFavoriteBeerWithRating(String email, long beerId, int tasteNote) {
        return JsonFavoriteBeer.builder()
                .userEmail(email)
                .beerId(beerId)
                .drunkBefore(true)
                .whereTasted("UK")
                .whenTasted(LocalDate.now())
                .tasteNote(tasteNote)
                .comments("It was pretty ok for a dinner.")
                .build();
    }

}
