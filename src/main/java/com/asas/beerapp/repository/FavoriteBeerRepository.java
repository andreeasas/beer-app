package com.asas.beerapp.repository;

import com.asas.beerapp.model.FavoriteBeer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteBeerRepository extends JpaRepository<FavoriteBeer, Long> {

    List<FavoriteBeer> findByUserEmail(String email);

    FavoriteBeer findByUserEmailAndBeerId(String email, long beerId);

    List<FavoriteBeer> findByUserEmailAndTasteNoteGreaterThanEqual(String email, int minTasteNote);

}