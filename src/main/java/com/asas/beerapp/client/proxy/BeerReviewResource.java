package com.asas.beerapp.client.proxy;

import com.asas.beerapp.model.BeerReview;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
 * Used for Integration Tests.
 **/
public interface BeerReviewResource {

    @GET
    @Produces(APPLICATION_JSON_VALUE)
    @Path("{email}")
     List<BeerReview> fetchReviewsByEmail(String email);

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
     void deleteReview(@PathVariable("reviewId") long id) ;
}
