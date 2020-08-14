package com.luketowell.webservices.error;

public class StoreNotFoundException extends RuntimeException{

        public StoreNotFoundException(String id){
            super ("Sorry, the store with id: " + id + " was not found.");
        }
}
