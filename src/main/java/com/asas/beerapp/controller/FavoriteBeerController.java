package com.asas.beerapp.controller;

import com.asas.beerapp.beerapp.api.JsonFavoriteBeerResponse;
import com.asas.beerapp.beerapp.api.JsonFavoriteBeer;
import com.asas.beerapp.model.FavoriteBeer;
import com.asas.beerapp.punkapi.JsonBeer;
import com.asas.beerapp.service.BeerReviewService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.asas.beerapp.beerapp.api.Builder.buildBeerReview;
import static com.asas.beerapp.beerapp.api.Builder.buildFavoriteBeer;

@Validated
@RestController
@RequestMapping(
        path = "${favorites.api.url}"
)
@CrossOrigin(origins = "${frontend.url}")
public class FavoriteBeerController {

    private Logger logger = LogManager.getLogger(FavoriteBeerController.class);

    private final BeerReviewService beerReviewService;

    private final BeerController  beerController;

    @Autowired
    public FavoriteBeerController(BeerReviewService beerReviewService, BeerController beerController) {
        this.beerReviewService = beerReviewService;
        this.beerController = beerController;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewReview(@RequestBody JsonFavoriteBeer jsonFavoriteBeer) {
        FavoriteBeer favoriteBeer = buildBeerReview(jsonFavoriteBeer);
        beerReviewService.insertBeerReview(favoriteBeer);
        logger.log(Level.INFO, "save favorite beer "+ jsonFavoriteBeer.getBeerId());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{email}"
    )
    public List<JsonFavoriteBeerResponse> fetchFavoritesByEmail(@PathVariable("email") String email) {
        List<FavoriteBeer> favoriteBeers = beerReviewService.selectAllReviewsByEmail(email);
        List<String> beerIds = favoriteBeers.stream().map(beerReview -> beerReview.getBeerId() + "").collect(Collectors.toList());
        String ids = String.join("|", beerIds);

        List<JsonBeer> jsonBeers = beerController.getBeersByIds(ids);
        Map<Long, JsonBeer> beers = jsonBeers.stream().collect(Collectors.toMap(JsonBeer::getId, Function.identity()));

        // build response
        ArrayList<JsonFavoriteBeerResponse> jsonFavoriteBeerResponses = new ArrayList<>();
        favoriteBeers.forEach(beerReview -> {
            JsonBeer jsonBeer = beers.get(beerReview.getBeerId());

            JsonFavoriteBeerResponse favoriteBeer = buildFavoriteBeer(beerReview, jsonBeer);
            jsonFavoriteBeerResponses.add(favoriteBeer);
        });

        return jsonFavoriteBeerResponses;
    }

}
