package com.asas.beerapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"beerId", "userEmail"})})
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteBeer implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Email
    private String userEmail;

    @NotNull
    private long beerId;

    @EqualsAndHashCode.Exclude
    private boolean drunkBefore;

    @EqualsAndHashCode.Exclude
    @Column(name = "where_tasted")
    private String where;

    @EqualsAndHashCode.Exclude
    @Column(name = "when_tasted")
    private LocalDate when;

    @EqualsAndHashCode.Exclude
    //    @Min(1)
    //    @Max(5)
    private int tasteNote;

    @EqualsAndHashCode.Exclude
    private String comments;

}
