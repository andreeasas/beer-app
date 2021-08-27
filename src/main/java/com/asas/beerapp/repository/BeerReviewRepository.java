package com.asas.beerapp.repository;

import com.asas.beerapp.model.BeerReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerReviewRepository extends JpaRepository<BeerReview, Long> {

    List<BeerReview> findByUserEmail(String email);

    BeerReview findByUserEmailAndBeerId(String email, long beerId);

    List<BeerReview> findByUserEmailAndTasteNoteGreaterThanEqual(String email, int minTasteNote);

}