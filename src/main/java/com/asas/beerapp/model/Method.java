package com.asas.beerapp.model;

import com.asas.beerapp.model.measures.Temperature;

import java.util.List;

public class Method {
    private List<MashTemperature> mashTemp;
    private Temperature fermentation;
    private String twist;

    private class MashTemperature {
        private Temperature temp;
        private int duration;
    }
}


