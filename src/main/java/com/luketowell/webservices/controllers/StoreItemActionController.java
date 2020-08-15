package com.luketowell.webservices.controllers;

import com.luketowell.webservices.error.StoreItemActionNotFoundException;
import com.luketowell.webservices.models.StoreItemAction;
import com.luketowell.webservices.repositories.StoreItemActionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public StoreItemAction findStoreItemActionById(@PathVariable Long id){
        return storeItemActionRepository.findById(id)
                .orElseThrow(() -> new StoreItemActionNotFoundException(id));
    }
}
