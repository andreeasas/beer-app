package com.asas.beerapp.controller;

import com.asas.beerapp.appapi.JsonFavoriteBeer;
import com.asas.beerapp.appapi.JsonReview;
import com.asas.beerapp.model.BeerReview;
import com.asas.beerapp.punkapi.JsonBeer;
import com.asas.beerapp.service.BeerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.asas.beerapp.appapi.Builder.buildBeerReview;
import static com.asas.beerapp.appapi.Builder.buildFavoriteBeer;

@Validated
@RestController
@RequestMapping(
        path = "${favorites.api.url}"
)
@CrossOrigin(origins = "${frontend.url}")
public class FavoriteBeerController {

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
    public void insertNewReview(@RequestBody JsonReview jsonReview) {
        BeerReview beerReview = buildBeerReview(jsonReview);
        beerReviewService.insertBeerReview(beerReview);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{email}"
    )
    public List<JsonFavoriteBeer> fetchFavoritesByEmail(@PathVariable("email") String email) {
        List<BeerReview> beerReviews = beerReviewService.selectAllReviewsByEmail(email);
        List<String> beerIds = beerReviews.stream().map(beerReview -> beerReview.getBeerId() + "").collect(Collectors.toList());
        String ids = String.join("|", beerIds);

        List<JsonBeer> jsonBeers = beerController.getBeersByIds(ids);
        Map<Long, JsonBeer> beers = jsonBeers.stream().collect(Collectors.toMap(JsonBeer::getId, Function.identity()));

        // build response
        ArrayList<JsonFavoriteBeer> jsonFavoriteBeers = new ArrayList<>();
        beerReviews.forEach(beerReview -> {
            JsonBeer jsonBeer = beers.get(beerReview.getBeerId());

            JsonFavoriteBeer favoriteBeer = buildFavoriteBeer(beerReview, jsonBeer);
            jsonFavoriteBeers.add(favoriteBeer);
        });

        return jsonFavoriteBeers;
    }

}
