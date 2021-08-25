package com.asas.beerapp.integration.tests;

import com.asas.beerapp.client.proxy.BeerResource;
import com.asas.beerapp.model.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.ws.rs.NotFoundException;
import java.util.List;

import static com.asas.beerapp.Samples.createDefaultBeerSample;
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
    void shouldInsertNewBeer() {
        // given
        long id = 1L;
        Beer beer = createDefaultBeerSample(id);

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
        beerResource.insertNewBeer(createDefaultBeerSample(id));

        // when
        beerResource.deleteBeer(id);

        // then
        assertThatThrownBy(() -> beerResource.fetchBeer(id)).isInstanceOf(NotFoundException.class);
    }

}
