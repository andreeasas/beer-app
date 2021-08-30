package com.asas.beerapp.client.proxy;

import com.asas.beerapp.model.FavoriteBeer;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
 * Used for Integration Tests.
 **/
@Consumes(APPLICATION_JSON_VALUE)
public interface BeerReviewResource {

    @GET
    @Produces(APPLICATION_JSON_VALUE)
    @Path("{email}")
    List<FavoriteBeer> fetchReviewsByEmail(@PathParam("email") String email);

    @POST
    @Produces(APPLICATION_JSON_VALUE)
    @Consumes(APPLICATION_JSON_VALUE)
    FavoriteBeer insertNewReview(@Valid @RequestBody FavoriteBeer favoriteBeer);

    @PUT
    @Produces(APPLICATION_JSON_VALUE)
    @Consumes(APPLICATION_JSON_VALUE)
    void updateReview(FavoriteBeer favoriteBeer);

    @DELETE
    @Produces(APPLICATION_JSON_VALUE)
    @Path("{reviewId}")
    void deleteReview(@PathParam("reviewId") long id);
}
