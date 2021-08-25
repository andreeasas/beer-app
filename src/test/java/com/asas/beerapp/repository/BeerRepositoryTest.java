package com.asas.beerapp.repository;


import com.asas.beerapp.model.Beer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.asas.beerapp.Samples.createDefaultBeerSample;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @BeforeEach
    void setUp() {
        beerRepository.save(createDefaultBeerSample(1L));
    }

    @Test
    void findByOptionalParamsAllFields() {
        // given setup
        float fermentationGt = 10f;
        float fermentationLt = 30f;
        int ibuGt = 50;
        int ibuLt = 100;

        // when
        List<Beer> beers = beerRepository.findByOptionalParams(fermentationGt, fermentationLt, ibuGt, ibuLt);

        // then
        assertThat(beers.size()).isEqualTo(1);
        Beer beer = beers.get(0);

        assertThat(beer.getFermentation()).isNotNull();
        assertThat(beer.getFermentation().getTemperatureValue()).isGreaterThan(fermentationGt);
        assertThat(beer.getFermentation().getTemperatureValue()).isLessThan(fermentationLt);
        assertThat(beer.getIbu()).isGreaterThan(ibuGt);
        assertThat(beer.getIbu()).isLessThan(ibuLt);
    }

    @Test
    void findByOptionalParamsNoField() {
        // given setup

        // when
        List<Beer> beers = beerRepository.findByOptionalParams(null, null, null, null);

        // then
        List<Beer> allBeers = beerRepository.findAll();
        assertThat(beers.size()).isEqualTo(allBeers.size());
    }

    @Test
    void findByOptionalParamsRandomFields() {
        // given setup
        Float fermentationGt = null;
        Float fermentationLt = null;
        Integer ibuGt = null;
        Integer ibuLt = 100;

        // when
        List<Beer> beers = beerRepository.findByOptionalParams(fermentationGt, fermentationLt, ibuGt, ibuLt);

        // then
        assertThat(beers.size()).isEqualTo(1);
        assertThat(beers.get(0).getIbu()).isLessThan(ibuLt);
    }
}