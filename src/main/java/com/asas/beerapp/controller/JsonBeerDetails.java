package com.asas.beerapp.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonBeerDetails {

    private long id;
    private String name;
    private String description;
    private String imageUrl;
    private List<String> foodPairings;
}
