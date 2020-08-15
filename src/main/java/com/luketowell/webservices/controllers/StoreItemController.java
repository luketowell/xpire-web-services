package com.luketowell.webservices.controllers;

import com.luketowell.webservices.error.StoreItemNotFoundException;
import com.luketowell.webservices.models.StoreItem;
import com.luketowell.webservices.repositories.StoreItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("storeitem")
public class StoreItemController {
    StoreItemRepository storeItemRepository;

    public StoreItemController(StoreItemRepository storeItemRepository) {
        this.storeItemRepository = storeItemRepository;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<StoreItem> getAllStoreItems() {
        return storeItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public StoreItem findStoreItemById(@PathVariable Long id){
        return storeItemRepository.findById(id)
                .orElseThrow(() -> new StoreItemNotFoundException(id));
    }

}
