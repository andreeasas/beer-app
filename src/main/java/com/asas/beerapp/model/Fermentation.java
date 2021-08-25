package com.asas.beerapp.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Fermentation implements Serializable {

    private float temperatureValue;
    private String unit;

    public Fermentation() {
    }

    public Fermentation(float temperatureValue, String unit) {
        this.temperatureValue = temperatureValue;
        this.unit = unit;
    }

    public float getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(float temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
