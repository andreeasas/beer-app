package com.asas.beerapp.integration.tests;

import com.asas.beerapp.client.proxy.BeerController;
import com.asas.beerapp.appapi.JsonBeerSearchCriteria;
import com.asas.beerapp.punkapi.JsonBeer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BeersIntegrationTest {

    @Autowired
    private BeerController beerController;

    @Test
    void shouldGetAllBeers() {
        // given

        // when
        List<JsonBeer> allBeers = beerController.getAllBeers();

        // then
        assertThat(allBeers.isEmpty()).isFalse();
    }

    @Test
    void shouldGetBeersByIds() {
        // given
        String ids = "1|2|3";

        // when
        List<JsonBeer> beersByIds = beerController.getBeersByIds(ids);

        // then
        assertThat(beersByIds.size()).isEqualTo(3);
        for (JsonBeer jsonBeer : beersByIds) {
            assertThat(jsonBeer.getId()).isIn(1L, 2L, 3L);
        }
    }

    @Test
    void shouldGetBeersByCriteria() {
        // given
        JsonBeerSearchCriteria jsonSearchCriteria = JsonBeerSearchCriteria.builder()
                .ibuGt(8)
                .ibuLt(40)
                .yeast("Ale")
                .food("spicy food")
                .build();

        // when
        List<JsonBeer> beersByCriteria = beerController.getBeersByCriteria(jsonSearchCriteria);

        // then
        assertThat(beersByCriteria.isEmpty()).isFalse();
        for (JsonBeer beerByCriteria : beersByCriteria) {
            assertThat(beerByCriteria.getIbu()).isGreaterThan(8);
            assertThat(beerByCriteria.getIbu()).isLessThan(40);
            // yeast - fuzzy match, not checked
            // food - fuzzy match, not checked
//            assertThat(beerByCriteria.getFoodPairings().stream().filter(jsonBeer -> jsonBeer.toLowerCase().contains("spicy")).findAny().isPresent()).isTrue();
        }
    }

    @Test
    void shouldGetBeersByYeast() {
        // given
        JsonBeerSearchCriteria jsonSearchByYeast = JsonBeerSearchCriteria.builder()
                .yeast("Ale")
                .build();

        // when
        List<JsonBeer> beersByCriteria = beerController.getBeersByCriteria(jsonSearchByYeast);

        // then
        assertThat(beersByCriteria.isEmpty()).isFalse();
    }

    @Test
    void shouldGetBeersByNoCriteria() {
        // given
        JsonBeerSearchCriteria jsonNoCriteria = JsonBeerSearchCriteria.builder()
                .build();

        // when
        List<JsonBeer> beersByNoCriteria = beerController.getBeersByCriteria(jsonNoCriteria);

        // then
        List<JsonBeer> allBeers = beerController.getAllBeers();
        assertThat(beersByNoCriteria.size()).isEqualTo(allBeers.size());
    }

}
