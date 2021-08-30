package com.asas.beerapp.beerapp.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonBeerSearchCriteria {

    private int ibuGt;
    private int ibuLt;
    private String yeast;
    private String food;
}
