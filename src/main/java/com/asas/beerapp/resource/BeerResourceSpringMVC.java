package com.asas.beerapp.resource;

import com.asas.beerapp.model.Beer;
import com.asas.beerapp.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Validated
@RestController
@RequestMapping(
        path = "${beers.api.url}"
)
public class BeerResourceSpringMVC {

    private BeerService beerService;

    @Autowired
    public BeerResourceSpringMVC(BeerService beerService) {
        this.beerService = beerService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Beer> selectByOptionalParams(
            @RequestParam(required = false) Float fermentationGt
            , @RequestParam(required = false) Float fermentationLt
            , @RequestParam(required = false) Integer ibuGt
            , @RequestParam(required = false) Integer ibuLt) {
        return beerService.selectByOptionalParams(fermentationGt, fermentationLt, ibuGt, ibuLt);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{beerId}"
    )
    public Beer fetchBeer(@PathVariable("beerId") long beerId) {
        return beerService
                .selectBeerById(beerId)
                .orElseThrow(() -> new NotFoundException("Beer " + beerId + " not found"));
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Beer insertNewBeer(@Valid @RequestBody Beer beer) {
        return beerService.insertBeer(beer);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{beerId}"
    )
    public void deleteBeer(@PathVariable("beerId") long id) {
        beerService.removeBeer(id);
    }
}

