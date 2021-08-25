package com.asas.beerapp.integration.tests;

import com.asas.beerapp.client.proxy.BeerReviewResource;
import com.asas.beerapp.model.BeerReview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.asas.beerapp.Samples.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BeerReviewIntegrationTest {

//    @Autowired
//    private BeerReviewResource beerReviewResource;

    @Test
    void contextLoads() {
    }

//    @Test
//    void shouldFetchReviewsByEmail() {
//        // given
//        int startingEntries = beerReviewResource.fetchReviewsByEmail(defaultEmail).size();
//        beerReviewResource.insertNewReview(createReviewNotDrunk(defaultEmail, 1));
//        beerReviewResource.insertNewReview(createReviewNotDrunk(defaultEmail, 2));
//        beerReviewResource.insertNewReview(createReviewNotDrunk(secondEmail, 3));
//        beerReviewResource.insertNewReview(createReviewNotDrunk(secondEmail, 4));
//        beerReviewResource.insertNewReview(createReviewNotDrunk(secondEmail, 5));
//
//        // when
//        List<BeerReview> beersByEmail = beerReviewResource.fetchReviewsByEmail(defaultEmail);
//
//        // then
//
//        assertThat(beersByEmail.size()).isEqualTo(startingEntries + 2);
//    }

}
