package com.asas.beerapp.service;

import com.asas.beerapp.Samples;
import com.asas.beerapp.model.BeerReview;
import com.asas.beerapp.repository.BeerReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BeerReviewServiceTest {

    @Mock
    private BeerReviewRepository reviewRepository;

    @InjectMocks
    private BeerReviewService reviewService;

    @Test
    void selectAllReviewsByEmail() {
    }

    @Test
    void shouldInsertBeerReview() {
        // given
        BeerReview beerReview = Samples.createDefaultReview();
        given(reviewRepository.save(any(BeerReview.class))).willReturn(beerReview);

        // when
        BeerReview insertBeerReview = reviewService.insertBeerReview(beerReview);

        // then
        assertThat(insertBeerReview).isEqualTo(beerReview);
    }

}