package com.asas.beerapp.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Beer implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;

    private String tagline;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date firstBrewed;

    private String description;
    private String imgUrl;

    @NotNull
    @DecimalMin(value = "0", message = "Min ABV value should be 0.")
    @DecimalMax(value = "100", message = "Max ABV value should be 100.")
    private float abv;

    @NotNull
    @Min(value = 0, message = "Min IBU value should be 0.")
    @Max(value = 120, message = "Max IBU value should be 120.")
    private int ibu;

    private float targetFg;
    private float targetOg;

    @NotNull
    @DecimalMin(value = "0", message = "Min EBC value should be 0.")
    @DecimalMax(value = "100", message = "Max EBC value should be 100.")
    private float ebc;

    private float srm;
    private float ph;
    private float attenuationLevel;

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

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Date getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(Date firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public float getTargetFg() {
        return targetFg;
    }

    public void setTargetFg(float targetFg) {
        this.targetFg = targetFg;
    }

    public float getTargetOg() {
        return targetOg;
    }

    public void setTargetOg(float targetOg) {
        this.targetOg = targetOg;
    }

    public float getEbc() {
        return ebc;
    }

    public void setEbc(float ebc) {
        this.ebc = ebc;
    }

    public float getSrm() {
        return srm;
    }

    public void setSrm(float srm) {
        this.srm = srm;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }

    public float getAttenuationLevel() {
        return attenuationLevel;
    }

    public void setAttenuationLevel(float attenuationLevel) {
        this.attenuationLevel = attenuationLevel;
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
