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
    void shouldSelectAllBeers() {
        //given
        given(beerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))).willReturn(List.of(new Beer(1), new Beer(2)));

        //when
        List<Beer> allBeers = beerService.selectAllBeers();

        //then
        assertThat(allBeers).hasSize(2);
        assertThat(allBeers.get(0)).isNotNull().extracting("id").isEqualTo(1L);
        assertThat(allBeers.get(1)).isNotNull().extracting("id").isEqualTo(2L);
    }

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
    void ShouldSelectRandomBeer() {
        // given
        given(beerRepository.findRandomBeer()).willReturn(new Beer(1));

        // when
        Beer beer = beerService.selectRandomBeer();

        // then
        assertThat(beer).isNotNull();
    }


    @Test
    void insertBeer() {
        // given
        Beer beer = Samples.createBeerSample(1L);
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