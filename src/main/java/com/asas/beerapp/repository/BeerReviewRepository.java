package com.asas.beerapp.repository;

import com.asas.beerapp.model.BeerReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerReviewRepository extends JpaRepository<BeerReview, Long> {

    List<BeerReview> findByUserEmail(String email);

    List<BeerReview> findFuzzByBeerName(String beerName);

}