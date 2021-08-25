package com.asas.beerapp.model;

import com.asas.beerapp.model.measures.Amount;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Ingredients implements Serializable {

    public Ingredients() {
    }

    @ElementCollection
    private List<Ingredient> malt = new ArrayList<>();

    @ElementCollection
    private List<Ingredient> hops = new ArrayList<>();

    @NotBlank
    private String yeast;

    public Ingredients(@NotBlank List<Ingredient> malt, @NotBlank List<Ingredient> hops, @NotBlank String yeast) {
        this.malt = malt;
        this.hops = hops;
        this.yeast = yeast;
    }

    public List<Ingredient> getMalt() {
        return malt;
    }

    public List<Ingredient> getHops() {
        return hops;
    }

    public String getYeast() {
        return yeast;
    }
}

@Embeddable
@Access(AccessType.FIELD)
class Ingredient implements Serializable {

    @NotBlank
    private String name;

//    @Embedded
//    private Amount amount;

    private String add;
    private String attribute;

    public String getName() {
        return name;
    }

//    public Amount getAmount() {
//        return amount;
//    }

    public String getAdd() {
        return add;
    }

    public String getAttribute() {
        return attribute;
    }
}