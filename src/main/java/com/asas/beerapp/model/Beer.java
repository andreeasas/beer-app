package com.asas.beerapp.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Beer implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;

//    private String tagline;
//
//    @NotNull
//    @Temporal(TemporalType.DATE)
//    private Date firstBrewed;
//
//    private String description;
    private String imgUrl;

    @NotNull
    @DecimalMin(value = "0", message = "Min ABV value should be 0.")
    @DecimalMax(value = "100", message = "Max ABV value should be 100.")
    private float abv;

    @NotNull
    @Min(value = 0, message = "Min IBU value should be 0.")
    @Max(value = 120, message = "Max IBU value should be 120.")
    private int ibu;

//    private float targetFg;
//    private float targetOg;

    @NotNull
    @DecimalMin(value = "0", message = "Min EBC value should be 0.")
    @DecimalMax(value = "100", message = "Max EBC value should be 100.")
    private float ebc;

//    private float srm;
//    private float ph;
//    private float attenuationLevel;

//    private Volume volume;
//    private Volume boilVolume;
//    private Method method;

    @Embedded
    private Ingredients ingredients;

    @ElementCollection
    private List<String> foodPairing;

//    private String brewersTips;
//    private String contributedBy;

    public Beer() {
    }

    public Beer(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public float getAbv() {
        return abv;
    }

    public void setAbv(float abv) {
        this.abv = abv;
    }

    public int getIbu() {
        return ibu;
    }

    public void setIbu(int ibu) {
        this.ibu = ibu;
    }

    public float getEbc() {
        return ebc;
    }

    public void setEbc(float ebc) {
        this.ebc = ebc;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getFoodPairing() {
        return foodPairing;
    }

    public void setFoodPairing(List<String> foodPairing) {
        this.foodPairing = foodPairing;
    }

}
