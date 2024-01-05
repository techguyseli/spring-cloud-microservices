package com.mcommandes.mcommandes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mcommandes.mcommandes.exceptions.CommandeNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler 
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { CommandeNotFoundException.class })
    public ResponseEntity<String> handleConflict(CommandeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
