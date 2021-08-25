package com.asas.beerapp.punkapi;

import com.asas.beerapp.util.Util;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonBeerTest {

    @SneakyThrows
    @Test
    public void testBeerDeserializer() {

        String json = Util.readFile("punkapi/beer.json");
        JsonBeer actual = Deserializer.objectMapper
                .readValue(json, JsonBeer.class);

        JsonBeer.JsonBeerBuilder jsonBeerBuilder = new JsonBeer.JsonBeerBuilder();
        JsonBeer expected = jsonBeerBuilder
                .id(192)
                .name("Punk IPA 2007 - 2010")
                .tagline("Post Modern Classic. Spiky. Tropical. Hoppy.")
                .description("Our flagship beer that kick started the craft beer revolution. This is James and Martin's original take on an American IPA, subverted with punchy New Zealand hops. Layered with new world hops to create an all-out riot of grapefruit, pineapple and lychee before a spiky, mouth-puckering bitter finish.")
                .imageUrl("https://images.punkapi.com/v2/192.png")
                .abv(6.0f)
                .ibu(60)
                .targetFg(1010.0f)
                .targetOg(1056.0f)
                .ebc(17.0f)
//                .ingredients(
//                        new JsonIngredients.JsonIngredientsBuilder()
//                                .malt(new JsonIngredient.JsonIngredientBuilder()
//                                        .name("Extra Pale")
//                                        .build()
//                                )
//                                .hops(new JsonIngredient.JsonIngredientBuilder()
//                                        .name("Ahtanum")
//                                        .build())
//                                .hops(new JsonIngredient.JsonIngredientBuilder()
//                                        .name("Chinook")
//                                        .build())
//                                .yeast("Wyeast 1056 - American Ale™")
//                                .build()
//                )
                .foodPairing("Spicy carne asada with a pico de gallo sauce")
                .foodPairing("Shredded chicken tacos with a mango chilli lime salsa")
                .foodPairing("Cheesecake with a passion fruit swirl sauce")
                .build();

        assertEquals(expected, actual);
    }
}