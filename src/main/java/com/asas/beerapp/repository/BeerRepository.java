package com.asas.beerapp.repository;

import com.asas.beerapp.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {

    @Query(value = "SELECT * FROM beer " +
            " WHERE " +
            " (:fermentationGt is null or beer.temperature_value > :fermentationGt) " +
            " and (:fermentationLt is null or beer.temperature_value < :fermentationLt)" +
            " and (:ibuGt is null or beer.ibu > :ibuGt) " +
            " and (:ibuLt is null or beer.ibu < :ibuLt)",
            nativeQuery = true)
    List<Beer> findByOptionalParams(Float fermentationGt, Float fermentationLt, Integer ibuGt, Integer ibuLt);

}
