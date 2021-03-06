package com.asas.beerapp.controller;

import com.asas.beerapp.beerapp.api.JsonBeerSearchCriteria;
import com.asas.beerapp.punkapi.JsonBeer;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Validated
@RestController
@RequestMapping(
        path = "${beers.api.url}"
)
@CrossOrigin(origins = "${frontend.url}")
public class BeerController {

    private Logger logger = LogManager.getLogger(BeerController.class);

    private final RestTemplate restTemplate;

    @Autowired
    public BeerController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String PUNKAPI_URL = "https://api.punkapi.com/v2/beers";


    // TODO - IMPORTANT: the response should send an object containing the JsonBeer. In case that other details should be added, the api is broken.

    @Operation(summary = "Get all beers")
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<JsonBeer> getAllBeers() {
        JsonBeer[] jsonBeers = restTemplate.getForObject(PUNKAPI_URL, JsonBeer[].class);
        assert jsonBeers != null;
        logger.log(Level.INFO, "get all beers " + jsonBeers.length);
        return Arrays.asList(jsonBeers);
    }

    @Operation(summary = "Get beers by ids")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get beers by ids",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = JsonBeer.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Beers not found",
                    content = @Content)})
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{beerIds}"
    )
    public List<JsonBeer> getBeersByIds(@PathVariable("beerIds") String ids) {
        JsonBeer[] jsonBeers = restTemplate.getForObject(PUNKAPI_URL + "?ids=" + ids, JsonBeer[].class);
        assert jsonBeers != null;
        logger.log(Level.INFO, "get beers with ids " + ids);
        return Arrays.asList(jsonBeers);
    }

    @Operation(summary = "Get beers by criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found beers by criteria",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = JsonBeer.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid data supplied",
                    content = @Content)})
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<JsonBeer> getBeersByCriteria(@RequestBody JsonBeerSearchCriteria jsonBeerSearchCriteria) {
        ArrayList<String> criteria = new ArrayList<>();
        if (jsonBeerSearchCriteria.getIbuGt() != 0) {
            criteria.add("ibu_gt=" + jsonBeerSearchCriteria.getIbuGt());
        }
        if (jsonBeerSearchCriteria.getIbuLt() != 0) {
            criteria.add("ibu_lt=" + jsonBeerSearchCriteria.getIbuLt());
        }
        if (jsonBeerSearchCriteria.getYeast() != null && !jsonBeerSearchCriteria.getYeast().trim().isEmpty()) {
            String yeast = jsonBeerSearchCriteria.getYeast().replace(' ', '_');
            criteria.add("yeast=" + yeast);
        }
        if (jsonBeerSearchCriteria.getFood() != null && !jsonBeerSearchCriteria.getFood().trim().isEmpty()) {
            String food = jsonBeerSearchCriteria.getFood().replace(' ', '_');
            criteria.add("food=" + food);
        }
        String queryParams = criteria.isEmpty() ? "" : "?" + String.join("&", criteria);

        JsonBeer[] jsonBeers = restTemplate.getForObject(PUNKAPI_URL + queryParams, JsonBeer[].class);
        assert jsonBeers != null;
        String[] ids = Arrays.stream(jsonBeers).map(jsonBeer -> "" + jsonBeer.getId()).toArray(String[]::new);
        logger.log(Level.INFO, "retrieved beers for params " + queryParams + " = " + Arrays.toString(ids));
        return Arrays.asList(jsonBeers);
    }


}
