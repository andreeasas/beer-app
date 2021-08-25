package com.asas.beerapp.model.measures;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable
public class Amount {

//    @NotNull
//    private float value;

//    @Enumerated(EnumType.STRING)
//    private AmountUnit unit;
//
//    public double getValue() {
//        return value;
//    }
//
//    public AmountUnit getUnit() {
//        return unit;
//    }
}

enum AmountUnit{
    GRAMS("grams"),
    KILOGRAMS("kilograms");

    public final String label;

    private AmountUnit(String label) {
        this.label = label;
    }
}
