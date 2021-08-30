package com.asas.beerapp.beerapp.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonBeerDetails {

    @NotNull
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private String imageUrl;
    @NotBlank
    private List<String> foodPairings;
}
