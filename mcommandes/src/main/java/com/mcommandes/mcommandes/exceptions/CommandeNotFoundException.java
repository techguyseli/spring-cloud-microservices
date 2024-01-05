package com.mcommandes.mcommandes.exceptions;

public class CommandeNotFoundException extends Exception{

    public CommandeNotFoundException(Long id){
        super("The order with the ID " + id + " was not found");
    }
    
}
