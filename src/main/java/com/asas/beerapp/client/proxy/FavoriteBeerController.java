package com.asas.beerapp.client.proxy;

import com.asas.beerapp.beerapp.api.JsonFavoriteBeer;
import com.asas.beerapp.beerapp.api.JsonReview;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
 * Used for Integration Tests.
 **/
@Consumes(APPLICATION_JSON_VALUE)
public interface FavoriteBeerController {

    @GET
    @Produces(APPLICATION_JSON_VALUE)
    @Path("{email}")
    List<JsonFavoriteBeer> fetchFavoritesByEmail(@PathParam("email") String email);

    @POST
    @Consumes(APPLICATION_JSON_VALUE)
    void insertNewReview(@RequestBody JsonReview jsonReview);

}