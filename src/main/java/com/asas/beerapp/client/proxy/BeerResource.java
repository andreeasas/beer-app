package com.asas.beerapp.client.proxy;

import com.asas.beerapp.model.Beer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
 * Used for Integration Tests.
**/
@Consumes(APPLICATION_JSON_VALUE)
public interface BeerResource {

    @GET
    @Produces(APPLICATION_JSON_VALUE)
    List<Beer> selectByOptionalParams(
            @RequestParam(required = false) Float fermentationGt
            , @RequestParam(required = false) Float fermentationLt
            , @RequestParam(required = false) Integer ibuGt
            , @RequestParam(required = false) Integer ibuLt);

    @GET
    @Produces(APPLICATION_JSON_VALUE)
    @Path("{beerId}")
    Beer fetchBeer(@PathParam("beerId") long beerId);

    @POST
    @Produces(APPLICATION_JSON_VALUE)
    @Consumes(APPLICATION_JSON_VALUE)
    Beer insertNewBeer(Beer beer);

    @DELETE
    @Produces(APPLICATION_JSON_VALUE)
    @Path("{beerId}")
    void deleteBeer(@PathParam("beerId") long id);

}