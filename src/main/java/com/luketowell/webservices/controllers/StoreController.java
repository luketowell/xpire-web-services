package com.luketowell.webservices.controllers;

import com.luketowell.webservices.error.StoreNotFoundException;
import com.luketowell.webservices.models.Store;
import com.luketowell.webservices.repositories.StoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("store")
public class StoreController {

    StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping("/all")
    public Iterable<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable String id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new StoreNotFoundException(id));
    }
}
