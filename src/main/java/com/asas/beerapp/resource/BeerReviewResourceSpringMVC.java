package com.asas.beerapp.resource;

import com.asas.beerapp.model.BeerReview;
import com.asas.beerapp.service.BeerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping(
        path = "${reviews.api.url}"
)
public class BeerReviewResourceSpringMVC {

    private final BeerReviewService beerReviewService;

    @Autowired
    public BeerReviewResourceSpringMVC(BeerReviewService beerReviewService) {
        this.beerReviewService = beerReviewService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{email}"
    )
    public List<BeerReview> fetchReviewsByEmail(@PathVariable("email") String email) {
        return beerReviewService.selectAllReviewsByEmail(email);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BeerReview insertNewReview(@Valid @RequestBody BeerReview beerReview) {
        return beerReviewService.insertBeerReview(beerReview);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void updateReview(@Valid @RequestBody BeerReview beerReview) {
        beerReviewService.updateBeerReview(beerReview);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{reviewId}"
    )
    public void deleteReview(@PathVariable("reviewId") long id) {
        beerReviewService.removeBeerReview(id);
    }
}
