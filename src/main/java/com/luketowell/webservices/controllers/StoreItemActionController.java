package com.luketowell.webservices.controllers;

import com.luketowell.webservices.models.StoreItemAction;
import com.luketowell.webservices.repositories.StoreItemActionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("actions")
public class StoreItemActionController {

    StoreItemActionRepository storeItemActionRepository;

    public StoreItemActionController(StoreItemActionRepository storeItemActionRepository) {
        this.storeItemActionRepository = storeItemActionRepository;
    }

    @GetMapping("/all")
    public Iterable<StoreItemAction>getAllActions(){
        return storeItemActionRepository.findAll();
    }
}
