package com.asas.beerapp.service;

import com.asas.beerapp.Samples;
import com.asas.beerapp.model.Beer;
import com.asas.beerapp.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BeerServiceTest {

    @Mock
    private BeerRepository beerRepository;

    @InjectMocks
    private BeerService beerService;

    @Test
    void shouldSelectBeerById() {
        // given
        given(beerRepository.findById(1L)).willReturn(Optional.of(new Beer(1)));

        // when
        Optional<Beer> beerOptional = beerService.selectBeerById(1L);

        // then
        assertThat(beerOptional.isPresent()).isTrue();
        assertThat(beerOptional.get().getId()).isEqualTo(1L);
    }

    @Test
    void insertBeer() {
        // given
        Beer beer = Samples.createDefaultBeerSample(1L);
        given(beerRepository.save(any(Beer.class))).willReturn(beer);

        // when
        Beer insertedBeer = beerService.insertBeer(beer);

        // then
        assertThat(insertedBeer).isEqualToComparingFieldByField(beer);
    }

    @Test
    void removeBeer() {
        // TODO
    }
}