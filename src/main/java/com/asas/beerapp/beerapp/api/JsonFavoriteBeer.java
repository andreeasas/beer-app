package com.asas.beerapp.beerapp.api;

import com.asas.beerapp.model.FavoriteBeer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonFavoriteBeer {

    @NotNull
    private long id;

    @NotNull
    @Email
    private String userEmail;

    @NotNull
    private long beerId;

    private boolean drunkBefore;
    private String whereTasted;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate whenTasted;
    private int tasteNote;
    private String comments;

    public FavoriteBeer toFavoriteBeer() {
       return FavoriteBeer.builder()
                .userEmail(this.getUserEmail())
                .beerId(this.beerId)
                .drunkBefore(this.drunkBefore)
                .where(this.whereTasted)
                .when(this.whenTasted)
                .tasteNote(this.tasteNote)
                .comments(this.comments)
                .build();
    }

}
