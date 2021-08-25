package com.asas.beerapp.service;

import com.asas.beerapp.model.Beer;
import com.asas.beerapp.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

    private BeerRepository beerRepository;

    @Autowired
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public List<Beer> selectAllBeers() {
        return beerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<Beer> selectBeerById(long id) {
        return beerRepository.findById(id);
    }

    public Beer selectRandomBeer() {
        Beer randomBeer = beerRepository.findRandomBeer();
        if (randomBeer == null) {
            throw new NotFoundException("No random beer was found.");
        }
        return randomBeer;
    }

    public Beer insertBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    public void removeBeer(long id) {
        beerRepository.findById(id).orElseThrow(() -> new NotFoundException("Beer " + id + " not found"));
        beerRepository.deleteById(id);
    }

    public List<Beer> selectFuzzByFoodPairing(String foodDetails) {
        return beerRepository.findFuzzByFoodPairing(foodDetails);
    }

    public List<Beer> selectByOptionalParams(Float abvGt, Float abvLt, Integer ibuGt, Integer ibuLt, Float ebcGt, Float ebcLt) {
        return beerRepository.findByOptionalParams(abvGt, abvLt, ibuGt, ibuLt, ebcGt, ebcLt);
    }

}
