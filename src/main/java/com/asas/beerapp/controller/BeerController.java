package com.asas.beerapp.controller;

import com.asas.beerapp.punkapi.JsonBeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class BeerController {

    private final RestTemplate restTemplate;

    @Autowired
    public BeerController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String url = "https://api.punkapi.com/v2/beers";

    @GetMapping("/beers")
    public List<JsonBeer> getBeers() {
        JsonBeer[] jsonBeers = restTemplate.getForObject(url, JsonBeer[].class);
        assert jsonBeers != null;
        return Arrays.asList(jsonBeers);
    }

}
