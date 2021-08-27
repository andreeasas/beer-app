package com.asas.beerapp.controller;

import com.asas.beerapp.punkapi.JsonBeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Validated
@RestController
@RequestMapping(
        path = "${beers.api.url}"
)
@CrossOrigin(origins = "${frontend.url}")
public class BeerController {

    private final RestTemplate restTemplate;

    @Autowired
    public BeerController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String PUNKAPI_URL = "https://api.punkapi.com/v2/beers";

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<JsonBeer> getBeers() {
        JsonBeer[] jsonBeers = restTemplate.getForObject(PUNKAPI_URL, JsonBeer[].class);
        assert jsonBeers != null;
        return Arrays.asList(jsonBeers);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{beerIds}"
    )
    public List<JsonBeer> getBeersByIds(@PathVariable("beerIds") String ids) {
        JsonBeer[] jsonBeers = restTemplate.getForObject(PUNKAPI_URL + "?ids=" + ids, JsonBeer[].class);
        assert jsonBeers != null;
        return Arrays.asList(jsonBeers);
    }

}
