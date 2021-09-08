package com.asas.beerapp.controller;

import com.asas.beerapp.beerapp.api.JsonFavoriteBeer;
import com.asas.beerapp.beerapp.api.JsonFavoriteBeerResponse;
import com.asas.beerapp.model.FavoriteBeer;
import com.asas.beerapp.punkapi.JsonBeer;
import com.asas.beerapp.service.FavoriteBeerService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.asas.beerapp.beerapp.api.Mapper.buildFavoriteBeerResponse;

@Validated
@RestController
@RequestMapping(
        path = "${favorites.api.url}"
)
@CrossOrigin(origins = "${frontend.url}")
public class FavoriteBeerController {

    private Logger logger = LogManager.getLogger(FavoriteBeerController.class);

    private final FavoriteBeerService favoriteBeerService;

    private final BeerController beerController;

    @Autowired
    public FavoriteBeerController(FavoriteBeerService favoriteBeerService, BeerController beerController) {
        this.favoriteBeerService = favoriteBeerService;
        this.beerController = beerController;
    }

    @Operation(summary = "Save favorite beer")
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertFavoriteBeer(@RequestBody JsonFavoriteBeer jsonFavoriteBeer) {
        try {
            FavoriteBeer favoriteBeer = jsonFavoriteBeer.toFavoriteBeer();
            favoriteBeerService.insertFavoriteBeer(favoriteBeer);
            logger.log(Level.INFO, "save favorite beer " + jsonFavoriteBeer.getBeerId() + " for user with email " + jsonFavoriteBeer.getUserEmail());
        } catch (DataIntegrityViolationException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Beer " + jsonFavoriteBeer.getBeerId() + " is already saved as favorite", e);
        } catch (IllegalArgumentException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid data", e);
        }
    }

    @Operation(summary = "Get favorite beers by user email")
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{email}"
    )
    public List<JsonFavoriteBeerResponse> fetchFavoritesByEmail(@PathVariable("email") String email) {
        List<FavoriteBeer> favoriteBeers = favoriteBeerService.selectFavoriteBeersByEmail(email);
        if (favoriteBeers.isEmpty()) {
            logger.log(Level.INFO, "user with email " + email + " has no favorite beer");
        }
        List<String> beerIds = favoriteBeers.stream().map(beerReview -> beerReview.getBeerId() + "").collect(Collectors.toList());
        String ids = String.join("|", beerIds);

        List<JsonBeer> jsonBeers = beerController.getBeersByIds(ids);
        Map<Long, JsonBeer> beers = jsonBeers.stream().collect(Collectors.toMap(JsonBeer::getId, Function.identity()));

        // build response
        ArrayList<JsonFavoriteBeerResponse> jsonFavoriteBeerResponses = new ArrayList<>();
        favoriteBeers.forEach(beerReview -> {
            JsonBeer jsonBeer = beers.get(beerReview.getBeerId());

            JsonFavoriteBeerResponse favoriteBeer = buildFavoriteBeerResponse(beerReview, jsonBeer);
            jsonFavoriteBeerResponses.add(favoriteBeer);
        });

        logger.log(Level.INFO, "get favorites for user with email " + email + " retrieved beers with ids " + ids);
        return jsonFavoriteBeerResponses;
    }

}
