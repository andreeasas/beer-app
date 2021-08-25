package com.asas.beerapp.repository;


import com.asas.beerapp.model.Beer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.asas.beerapp.Samples.createBeerSample;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @BeforeEach
    void setUp() {
        beerRepository.save(createBeerSample());
    }

    @Test
    void shouldFindRandomBeer() {
        assertThat(beerRepository.findRandomBeer()).isNotNull();
    }

    @Test
    void findFuzzByFoodPairing() {
        // TODO fix
        // given setup

        // when
        List<Beer> beers = beerRepository.findFuzzByFoodPairing("chicken");

        // then
        assertThat(beers.size()).isEqualTo(1);
    }

    @Test
    void findByOptionalParamsAllFields() {
        // given setup
        float abvGt = 5f;
        float abvLt = 30f;
        int ibuGt = 50;
        int ibuLt = 100;
        float ebcGt = 10f;
        float ebcLt = 30f;

        // when
        List<Beer> beers = beerRepository.findByOptionalParams(abvGt, abvLt, ibuGt, ibuLt, ebcGt, ebcLt);

        // then
        assertThat(beers.size()).isEqualTo(1);
        Beer beer = beers.get(0);
        assertThat(beer.getAbv()).isGreaterThan(abvGt);
        assertThat(beer.getAbv()).isLessThan(abvLt);
        assertThat(beer.getIbu()).isGreaterThan(ibuGt);
        assertThat(beer.getIbu()).isLessThan(ibuLt);
        assertThat(beer.getEbc()).isGreaterThan(ebcGt);
        assertThat(beer.getEbc()).isLessThan(ebcLt);
    }

    @Test
    void findByOptionalParamsNoField() {
        // given setup

        // when
        List<Beer> beers = beerRepository.findByOptionalParams(null, null, null, null, null, null);

        // then
        List<Beer> allBeers = beerRepository.findAll();
        assertThat(beers.size()).isEqualTo(allBeers.size());
    }

    @Test
    void findByOptionalParamsRandomFields() {
        // given setup
        Float abvGt = 5.0f;
        Float abvLt = null;
        Integer ibuGt = null;
        Integer ibuLt = 100;
        Float ebcGt = null;
        Float ebcLt = null;

        // when
        List<Beer> beers = beerRepository.findByOptionalParams(abvGt, abvLt, ibuGt, ibuLt, ebcGt, ebcLt);

        // then
        assertThat(beers.size()).isEqualTo(1);
        assertThat(beers.get(0).getAbv()).isGreaterThan(abvGt);
        assertThat(beers.get(0).getIbu()).isLessThan(ibuLt);
    }
}