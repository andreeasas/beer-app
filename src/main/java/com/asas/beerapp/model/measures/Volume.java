package com.asas.beerapp.model.measures;

import java.io.Serializable;

public class Volume implements Serializable {
    private double value;
    private VolumeUnit unit;
}

enum VolumeUnit{
    LITERS("liters");

    public final String label;

    private VolumeUnit(String label) {
        this.label = label;
    }
}


