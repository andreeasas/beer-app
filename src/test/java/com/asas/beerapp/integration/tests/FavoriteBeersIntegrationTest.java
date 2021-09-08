package com.asas.beerapp.integration.tests;

import com.asas.beerapp.client.proxy.FavoriteBeerController;
import com.asas.beerapp.beerapp.api.JsonFavoriteBeerResponse;
import com.asas.beerapp.repository.FavoriteBeerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.asas.beerapp.util.JsonFavoriteBeerSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FavoriteBeersIntegrationTest {

    @Autowired
    private FavoriteBeerController favoriteBeerController;

    @Autowired
    private FavoriteBeerRepository favoriteBeerRepository; // for cleanup only

    @AfterEach
    void tearDown() {
        favoriteBeerRepository.deleteAll();
    }

    // TODO check that insert is denied
    void shouldDenyFavoriteBeersWithInconsistentData() {
        // given DB cleanup

        // when
        favoriteBeerController.insertFavoriteBeer(createJsonFavoriteBeerWithoutMandatoryFields());
        favoriteBeerController.insertFavoriteBeer(createJsonFavoriteBeerWithInconsistentData(defaultEmail, 3));

        // then
    }

    @Test
    void shouldInsertFavoriteBeers() {
        // given DB cleanup

        // when
        favoriteBeerController.insertFavoriteBeer(createJsonFavoriteBeerNotDrunk(defaultEmail, 1));
        favoriteBeerController.insertFavoriteBeer(createJsonFavoriteBeerWithRating(defaultEmail, 2, 5));

        // then
        List<JsonFavoriteBeerResponse> jsonFavoriteBeerResponses = favoriteBeerController.fetchFavoriteBeersByEmail(defaultEmail);
        assertThat(jsonFavoriteBeerResponses.size()).isEqualTo(2);
    }

    @Test
    void shouldFetchFavoriteBeersByUserEmail() {
        // given
        favoriteBeerController.insertFavoriteBeer(createJsonFavoriteBeerNotDrunk(defaultEmail, 1));
        favoriteBeerController.insertFavoriteBeer(createJsonFavoriteBeerNotDrunk(defaultEmail, 2));
        favoriteBeerController.insertFavoriteBeer(createJsonFavoriteBeerNotDrunk(secondEmail, 1));
        favoriteBeerController.insertFavoriteBeer(createJsonFavoriteBeerNotDrunk(secondEmail, 2));
        favoriteBeerController.insertFavoriteBeer(createJsonFavoriteBeerNotDrunk(thirdEmail, 1));
        favoriteBeerController.insertFavoriteBeer(createJsonFavoriteBeerNotDrunk(thirdEmail, 2));

        // when
        List<JsonFavoriteBeerResponse> jsonFavoriteBeerResponses = favoriteBeerController.fetchFavoriteBeersByEmail(defaultEmail);

        //then
        assertThat(jsonFavoriteBeerResponses.size()).isEqualTo(2);
        assertThat(jsonFavoriteBeerResponses.get(0).getJsonFavoriteBeer().getUserEmail()).isEqualTo(defaultEmail);
        assertThat(jsonFavoriteBeerResponses.get(0).getJsonBeerDetails().getId()).isIn(1L, 2L);
        assertThat(jsonFavoriteBeerResponses.get(1).getJsonFavoriteBeer().getUserEmail()).isEqualTo(defaultEmail);
        assertThat(jsonFavoriteBeerResponses.get(1).getJsonBeerDetails().getId()).isIn(1L, 2L);
    }

}
