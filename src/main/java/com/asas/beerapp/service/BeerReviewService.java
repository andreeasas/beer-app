package com.asas.beerapp.service;

import com.asas.beerapp.model.BeerReview;
import com.asas.beerapp.repository.BeerReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
public class BeerReviewService {

    private BeerReviewRepository beerReviewRepository;

    @Autowired
    public BeerReviewService(BeerReviewRepository beerReviewRepository) {
        this.beerReviewRepository = beerReviewRepository;
    }

    public List<BeerReview> selectAllReviewsByEmail(String email) {
        return beerReviewRepository.findByUserEmail(email);
    }

    public List<BeerReview> selectAllReviewsByBeerName(String beerName) {
        return beerReviewRepository.findFuzzByBeerName(beerName);
    }

    public BeerReview insertBeer(BeerReview beerReview) {
        return beerReviewRepository.save(beerReview);
    }

    public void updateBeerReview(BeerReview beerReview) {
        beerReviewRepository.findById(beerReview.getId()).orElseThrow(() -> new NotFoundException("Beer review " + beerReview.getId() + " not found"));
        beerReviewRepository.save(beerReview);
    }

    public void removeBeerReview(long id) {
        beerReviewRepository.findById(id).orElseThrow(() -> new NotFoundException("Beer review " + id + " not found"));
        beerReviewRepository.deleteById(id);
    }
}
