package com.asas.beerapp.repository;

import com.asas.beerapp.model.BeerReview;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.asas.beerapp.util.BeerReviewSamples.*;

@DataJpaTest
class BeerReviewRepositoryTest {

    @Autowired
    BeerReviewRepository reviewRepository;

    @Test
    void shouldFindByUserEmailAndTasteNoteGreaterThanEqual() {
        // given
        reviewRepository.save(createReviewWithRating(defaultEmail, 1, 2));
        reviewRepository.save(createReviewWithRating(defaultEmail, 2, 3));
        reviewRepository.save(createReviewWithRating(defaultEmail, 3, 4));
        reviewRepository.save(createReviewWithRating(secondEmail, 1, 2));
        reviewRepository.save(createReviewWithRating(secondEmail, 2, 3));
        reviewRepository.save(createReviewWithRating(secondEmail, 3, 4));

        // when
        List<BeerReview> reviewsByEmailAndTaste = reviewRepository.findByUserEmailAndTasteNoteGreaterThanEqual(defaultEmail, 3);

        // then
        Assertions.assertThat(reviewsByEmailAndTaste.size()).isEqualTo(2);
    }
}