package com.mcommandes.mcommandes.exceptions;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(){
        super("Tried to manipulate an order with a product that doesn't exist.");
    }
    
}
