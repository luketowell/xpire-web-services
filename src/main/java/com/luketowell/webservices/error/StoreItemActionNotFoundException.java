package com.luketowell.webservices.error;

public class StoreItemActionNotFoundException extends RuntimeException{

    public StoreItemActionNotFoundException(Long id){
        super ("Sorry, the store item action with id: " + id + " was not found.");
    }
}