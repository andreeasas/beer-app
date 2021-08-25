package com.asas.beerapp.integration.tests;

import com.asas.beerapp.client.proxy.BeerResource;
import com.asas.beerapp.model.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.ws.rs.NotFoundException;
import java.util.List;

import static com.asas.beerapp.Samples.createBeerSample;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BeerIntegrationTest {

    @Autowired
    private BeerResource beerResource;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldFetchAllBeers() {
        // given
        int startingEntries = beerResource.fetchAllBeers().size();
        beerResource.insertNewBeer(createBeerSample(100L));
        beerResource.insertNewBeer(createBeerSample(101L));
        beerResource.insertNewBeer(createBeerSample(102L));
        beerResource.insertNewBeer(createBeerSample(103L));
        beerResource.insertNewBeer(createBeerSample(104L));

        // when
        List<Beer> allBeers = beerResource.fetchAllBeers();

        // then
        assertThat(allBeers.size()).isEqualTo(startingEntries + 5);
    }

    @Test
    void shouldInsertNewBeer() {
        // given
        long id = 1L;
        Beer beer = createBeerSample(id);

        // when
        beerResource.insertNewBeer(beer);

        // then
        Beer fetchBeer = beerResource.fetchBeer(id);
        assertThat(fetchBeer.getId()).isEqualTo(beer.getId());
        assertThat(fetchBeer.getName()).isEqualTo(beer.getName());
    }

    @Test
    void shouldDeleteBeer() {
        // given
        long id = 1L;
        beerResource.insertNewBeer(createBeerSample(id));

        // when
        beerResource.deleteBeer(id);

        // then
        assertThatThrownBy(() -> beerResource.fetchBeer(id)).isInstanceOf(NotFoundException.class);
    }

}
