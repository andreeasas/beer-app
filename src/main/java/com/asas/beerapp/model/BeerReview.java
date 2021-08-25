package com.asas.beerapp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

@Entity
public class BeerReview implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Email
    private String userEmail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beer_id",referencedColumnName="id")
    private Beer beer;

    private boolean drunkBefore;

    @Column(name = "where_tasted")
    private String where;

    @Temporal(TemporalType.DATE)
    @Column(name = "when_tasted")
    private Date when;

    @Min(1)
    @Max(5)
    private int tasteNote;
    private String comments;


    public long getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Beer getBeer() {
        return beer;
    }

    public boolean isDrunkBefore() {
        return drunkBefore;
    }

    public String getWhere() {
        return where;
    }

    public Date getWhen() {
        return when;
    }

    public int getTasteNote() {
        return tasteNote;
    }

    public String getComments() {
        return comments;
    }
}
