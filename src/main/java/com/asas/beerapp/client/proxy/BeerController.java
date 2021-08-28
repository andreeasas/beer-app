package com.asas.beerapp.client.proxy;

import com.asas.beerapp.appapi.JsonBeerSearchCriteria;
import com.asas.beerapp.punkapi.JsonBeer;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
 * Used for Integration Tests.
 **/
@Consumes(APPLICATION_JSON_VALUE)
public interface BeerController {

    @GET
    @Produces(APPLICATION_JSON_VALUE)
    List<JsonBeer> getAllBeers();

    @GET
    @Produces(APPLICATION_JSON_VALUE)
    @Path("{beerIds}")
    List<JsonBeer> getBeersByIds(@PathParam("beerIds") String ids);

    @POST
    @Consumes(APPLICATION_JSON_VALUE)
    @Produces(APPLICATION_JSON_VALUE)
    List<JsonBeer> getBeersByCriteria(@RequestBody JsonBeerSearchCriteria jsonBeerSearchCriteria);

}
