package com.asas.beerapp.exception.handling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Inconsistent beer review details")  // 404
public class InconsistentBeerDetailsException extends RuntimeException {

    public InconsistentBeerDetailsException(String message) {
        super(message);
    }
}
