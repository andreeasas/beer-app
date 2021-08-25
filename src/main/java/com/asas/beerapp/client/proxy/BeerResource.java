package com.asas.beerapp.client.proxy;

import com.asas.beerapp.model.Beer;
import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
 * Used for Integration Tests.
**/
public interface BeerResource {

    @GET
    @Produces(APPLICATION_JSON_VALUE)
    List<Beer> fetchAllBeers();

    @GET
    @Produces(APPLICATION_JSON_VALUE)
    @Path("{beerId}")
    Beer fetchBeer(@PathParam("beerId") long beerId);

    @GET
    @Produces(APPLICATION_JSON_VALUE)
    @Value("/random")
    Beer fetchRandomBeer();

    @POST
    @Produces(APPLICATION_JSON_VALUE)
    @Consumes(APPLICATION_JSON_VALUE)
    Beer insertNewBeer(Beer beer);

    @DELETE
    @Produces(APPLICATION_JSON_VALUE)
    @Path("{beerId}")
    void deleteBeer(@PathParam("beerId") long id);

}