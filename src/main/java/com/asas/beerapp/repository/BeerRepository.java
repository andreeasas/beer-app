package com.asas.beerapp.repository;

import com.asas.beerapp.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {

    // TODO fix
    List<Beer> findFuzzByFoodPairing(String foodDetails);

    @Query(value = "SELECT * FROM beer" +
            " ORDER BY RAND()" +
            " LIMIT 1",
            nativeQuery = true)
    Beer findRandomBeer();

    @Query(value = "SELECT * FROM beer " +
            " WHERE " +
            " (:abvGt is null or beer.abv > :abvGt) " +
            " and (:abvLt is null or beer.abv < :abvLt)" +
            " and (:ibuGt is null or beer.ibu > :ibuGt) " +
            " and (:ibuLt is null or beer.ibu < :ibuLt)" +
            " and (:ebcGt is null or beer.ebc > :ebcGt) " +
            " and (:ebcLt is null or beer.ebc < :ebcLt)",
            nativeQuery = true)
    List<Beer> findByOptionalParams(Float abvGt, Float abvLt, Integer ibuGt, Integer ibuLt, Float ebcGt, Float ebcLt);

}
