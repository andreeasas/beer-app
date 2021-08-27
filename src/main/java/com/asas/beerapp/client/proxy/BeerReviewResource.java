package com.asas.beerapp.client.proxy;

import com.asas.beerapp.model.BeerReview;
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
    List<BeerReview> fetchReviewsByEmail(@PathParam("email") String email);

    @POST
    @Produces(APPLICATION_JSON_VALUE)
    @Consumes(APPLICATION_JSON_VALUE)
     BeerReview insertNewReview(@Valid @RequestBody BeerReview beerReview) ;

    @PUT
    @Produces(APPLICATION_JSON_VALUE)
    @Consumes(APPLICATION_JSON_VALUE)
     void updateReview(BeerReview beerReview) ;

    @DELETE
    @Produces(APPLICATION_JSON_VALUE)
    @Path("{reviewId}")
     void deleteReview(@PathParam("reviewId") long id) ;
}
