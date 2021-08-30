package com.asas.beerapp.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"beerId", "userEmail"})})
public class FavoriteBeer implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Email
    private String userEmail;

    @NotBlank
    private long beerId;

    private boolean drunkBefore;

    @Column(name = "where_tasted")
    private String where;

    @Column(name = "when_tasted")
    private LocalDate when;

    //    @Min(1)
    //    @Max(5)
    private int tasteNote;
    private String comments;

    public FavoriteBeer() {
    }

    public long getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getBeerId() {
        return beerId;
    }

    public void setBeerId(long beerId) {
        this.beerId = beerId;
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

    public void setWhen(LocalDate when) {
        this.when = when;
    }

    public LocalDate getWhen() {
        return when;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteBeer that = (FavoriteBeer) o;
        return id == that.id && beerId == that.beerId && userEmail.equals(that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEmail, beerId);
    }
}
