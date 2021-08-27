package com.asas.beerapp.integration.tests;

import com.asas.beerapp.client.proxy.BeerReviewResource;
import com.asas.beerapp.model.BeerReview;
import com.asas.beerapp.repository.BeerReviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.asas.beerapp.Samples.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BeerReviewIntegrationTest {

    @Autowired
    private BeerReviewResource reviewResource;

    @Autowired
    private BeerReviewRepository reviewRepository; // for cleanup only

    @Test
    void contextLoads() {
    }

    @AfterEach
    void tearDown() {
        reviewRepository.deleteAll();
    }

    @Test
    void shouldFetchReviewsByEmail() {
        // given
        int startingEntries = reviewResource.fetchReviewsByEmail(defaultEmail).size();
        reviewResource.insertNewReview(createReviewNotDrunk(defaultEmail, 1));
        reviewResource.insertNewReview(createReviewNotDrunk(defaultEmail, 2));
        reviewResource.insertNewReview(createReviewNotDrunk(secondEmail, 1));
        reviewResource.insertNewReview(createReviewNotDrunk(secondEmail, 2));
        reviewResource.insertNewReview(createReviewNotDrunk(thirdEmail, 1));
        reviewResource.insertNewReview(createReviewNotDrunk(thirdEmail, 2));

        // when
        List<BeerReview> beersByEmail = reviewResource.fetchReviewsByEmail(defaultEmail);

        // then
        assertThat(beersByEmail.size()).isEqualTo(startingEntries + 2);
    }

    @Test
    void shouldInsertReview(){
        // given
        BeerReview beerReview = createReviewDrunk(defaultEmail, defaultBeerId);

        // when
        reviewResource.insertNewReview(beerReview);

        // then
        List<BeerReview> beerReviews = reviewResource.fetchReviewsByEmail(defaultEmail);
        assertThat(beerReviews.size()).isEqualTo(1);
        BeerReview fetchReview = beerReviews.get(0);
        assertThat(fetchReview.getBeerId()).isEqualTo(beerReview.getBeerId());
        assertThat(fetchReview.getUserEmail()).isEqualTo(beerReview.getUserEmail());
    }

}
