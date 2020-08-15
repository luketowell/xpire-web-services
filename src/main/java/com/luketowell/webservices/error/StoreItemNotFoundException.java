package com.luketowell.webservices.error;

public class StoreItemNotFoundException extends RuntimeException{

    public StoreItemNotFoundException(Long id){
        super ("Sorry, the store item with id: " + id + " was not found.");
    }
}