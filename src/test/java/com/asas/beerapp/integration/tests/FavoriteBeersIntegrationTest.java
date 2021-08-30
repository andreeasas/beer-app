package com.asas.beerapp.integration.tests;

import com.asas.beerapp.client.proxy.FavoriteBeerController;
import com.asas.beerapp.beerapp.api.JsonFavoriteBeer;
import com.asas.beerapp.repository.BeerReviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.asas.beerapp.util.JsonSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FavoriteBeersIntegrationTest {

    @Autowired
    private FavoriteBeerController favoriteBeerController;

    @Autowired
    private BeerReviewRepository reviewRepository; // for cleanup only

    @AfterEach
    void tearDown() {
        reviewRepository.deleteAll();
    }

    @Test
    void shouldDenyFavoriteBeersWithInconsistentData() {
        // given DB cleanup

        // when
        favoriteBeerController.insertNewReview(createJsonReviewWithoutMandatoryFields());
        favoriteBeerController.insertNewReview(createJsonReviewWithInconsistentData(defaultEmail, 3));

        // then
        // TODO check insert is denied
    }

    @Test
    void shouldInsertFavoriteBeers() {
        // given DB cleanup

        // when
        favoriteBeerController.insertNewReview(createJsonReviewNotDrunk(defaultEmail, 1));
        favoriteBeerController.insertNewReview(createJsonReviewWithRating(defaultEmail, 2, 5));

        // then
        List<JsonFavoriteBeer> jsonFavoriteBeers = favoriteBeerController.fetchFavoritesByEmail(defaultEmail);
        assertThat(jsonFavoriteBeers.size()).isEqualTo(2);
    }

    @Test
    void shouldFetchFavoriteBeersByUserEmail() {
        // given
        favoriteBeerController.insertNewReview(createJsonReviewNotDrunk(defaultEmail, 1));
        favoriteBeerController.insertNewReview(createJsonReviewNotDrunk(defaultEmail, 2));
        favoriteBeerController.insertNewReview(createJsonReviewNotDrunk(secondEmail, 1));
        favoriteBeerController.insertNewReview(createJsonReviewNotDrunk(secondEmail, 2));
        favoriteBeerController.insertNewReview(createJsonReviewNotDrunk(thirdEmail, 1));
        favoriteBeerController.insertNewReview(createJsonReviewNotDrunk(thirdEmail, 2));

        // when
        List<JsonFavoriteBeer> jsonFavoriteBeers = favoriteBeerController.fetchFavoritesByEmail(defaultEmail);

        //then
        assertThat(jsonFavoriteBeers.size()).isEqualTo(2);
        assertThat(jsonFavoriteBeers.get(0).getJsonReview().getUserEmail()).isEqualTo(defaultEmail);
        assertThat(jsonFavoriteBeers.get(0).getJsonBeerDetails().getId()).isIn(1L, 2L);
        assertThat(jsonFavoriteBeers.get(1).getJsonReview().getUserEmail()).isEqualTo(defaultEmail);
        assertThat(jsonFavoriteBeers.get(1).getJsonBeerDetails().getId()).isIn(1L, 2L);
    }

}
