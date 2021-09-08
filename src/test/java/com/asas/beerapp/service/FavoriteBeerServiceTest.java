package com.asas.beerapp.service;

import com.asas.beerapp.util.FavoriteBeerSamples;
import com.asas.beerapp.model.FavoriteBeer;
import com.asas.beerapp.repository.FavoriteBeerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.asas.beerapp.util.FavoriteBeerSamples.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FavoriteBeerServiceTest {

    @Mock
    private FavoriteBeerRepository reviewRepository;

    @InjectMocks
    private FavoriteBeerService reviewService;

    @Test
    void selectAllReviewsByEmail() {
    }

    @Test
    void shouldInsertBeerReview() {
        // given
        FavoriteBeer favoriteBeer = FavoriteBeerSamples.createReviewWithRating(defaultEmail, defaultBeerId, defaultTasteNote);
        given(reviewRepository.save(any(FavoriteBeer.class))).willReturn(favoriteBeer);

        // when
        FavoriteBeer insertFavoriteBeer = reviewService.insertFavoriteBeer(favoriteBeer);

        // then
        assertThat(insertFavoriteBeer).isEqualTo(favoriteBeer);
    }

}