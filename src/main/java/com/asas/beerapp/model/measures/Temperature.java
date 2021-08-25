package com.asas.beerapp.model.measures;

public class Temperature {
    private double value;
    private TemperatureUnit unit;
}

enum TemperatureUnit{
    CELSIUS("celsius");

    public final String label;

    private TemperatureUnit(String label) {
        this.label = label;
    }
}
