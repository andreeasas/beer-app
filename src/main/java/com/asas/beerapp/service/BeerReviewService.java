package com.asas.beerapp.service;

import com.asas.beerapp.model.FavoriteBeer;
import com.asas.beerapp.repository.FavoriteBeerRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Validated
@Service
public class BeerReviewService {

    private Logger logger = LogManager.getLogger(BeerReviewService.class);

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
        // TODO check for inconsistent data - e.g. whereTasted should not be set if drunkBefore is false
//        boolean reviewDetailsAdded = favoriteBeer.getWhere() != null || favoriteBeer.getWhen() != null
//                || favoriteBeer.getTasteNote() != 0;
//        if (!favoriteBeer.isDrunkBefore() && reviewDetailsAdded) {
//            // no taste details should be added
//            logger.log(Level.ERROR, "beer taste details were added for " + favoriteBeer.getBeerId() + ", although the beer was never tasted");
//            throw new InconsistentBeerDetailException("beer details were added for " + favoriteBeer.getBeerId() + ", although the beer was never tasted");
//        }

        try {
            return favoriteBeerRepository.save(favoriteBeer);
        } catch (DataIntegrityViolationException e) {
            logger.log(Level.ERROR, e.getMessage());
            logger.log(Level.ERROR, e.getCause().getMessage());
            throw e;
        }
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
