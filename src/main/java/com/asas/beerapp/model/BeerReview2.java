package com.asas.beerapp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.ZonedDateTime;

@Embeddable
public class BeerReview2 {
    @Email
    private String userEmail;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "beer_id",referencedColumnName="id")
//    private Beer beer;

    private boolean drunkBefore;

    @Column(name = "where_tasted")
    private String where;

    @Column(name = "when_tasted")
    private ZonedDateTime when;

    @Min(1)
    @Max(5)
    private int tasteNote;
    private String comments;

    public BeerReview2() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isDrunkBefore() {
        return drunkBefore;
    }

    public void setDrunkBefore(boolean drunkBefore) {
        this.drunkBefore = drunkBefore;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public ZonedDateTime getWhen() {
        return when;
    }

    public void setWhen(ZonedDateTime when) {
        this.when = when;
    }

    public int getTasteNote() {
        return tasteNote;
    }

    public void setTasteNote(int tasteNote) {
        this.tasteNote = tasteNote;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}