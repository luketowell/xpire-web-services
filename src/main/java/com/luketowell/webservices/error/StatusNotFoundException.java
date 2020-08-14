package com.luketowell.webservices.error;

public class StatusNotFoundException extends RuntimeException{

    public StatusNotFoundException(Long id){
        super ("Sorry, the status with id: " + id + " was not found.");
    }
}
