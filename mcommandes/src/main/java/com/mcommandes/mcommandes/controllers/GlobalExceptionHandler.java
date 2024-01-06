package com.mcommandes.mcommandes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mcommandes.mcommandes.exceptions.CommandeNotFoundException;
import com.mcommandes.mcommandes.exceptions.ProductNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { CommandeNotFoundException.class, ProductNotFoundException.class })
    public ResponseEntity<String> handleNotFound(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
