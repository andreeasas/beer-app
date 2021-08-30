package com.asas.beerapp.service;

import com.asas.beerapp.model.FavoriteBeer;
import com.asas.beerapp.repository.FavoriteBeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
public class BeerReviewService {

    private FavoriteBeerRepository favoriteBeerRepository;

    @Autowired
    public BeerReviewService(FavoriteBeerRepository favoriteBeerRepository) {
        this.favoriteBeerRepository = favoriteBeerRepository;
    }

    public List<FavoriteBeer> selectAllReviews() {
        return favoriteBeerRepository.findAll(Sort.by(Sort.Direction.ASC, "beerId"));
    }

    public List<FavoriteBeer> selectAllReviewsByEmail(String email) {
        return favoriteBeerRepository.findByUserEmail(email);
    }

    public FavoriteBeer insertBeerReview(FavoriteBeer favoriteBeer) {
        return favoriteBeerRepository.save(favoriteBeer);
    }
    public void updateBeerReview(FavoriteBeer favoriteBeer) {
        favoriteBeerRepository.findById(favoriteBeer.getId()).orElseThrow(() -> new NotFoundException("Beer review " + favoriteBeer.getId() + " not found"));
        favoriteBeerRepository.save(favoriteBeer);
    }

    public void removeBeerReview(long id) {
        favoriteBeerRepository.findById(id).orElseThrow(() -> new NotFoundException("Beer review " + id + " not found"));
        favoriteBeerRepository.deleteById(id);
    }

}
