package com.asas.beerapp.punkapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonMethod {

    private JsonFermentation fermentation;
}

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
class JsonFermentation {

    private JsonTemperature temp;
}

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
class JsonTemperature {

    private float value;
    private String unit;
}
