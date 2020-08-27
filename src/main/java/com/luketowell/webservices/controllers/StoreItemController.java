package com.luketowell.webservices.controllers;

import com.luketowell.webservices.error.StoreItemNotFoundException;
import com.luketowell.webservices.models.StoreItem;
import com.luketowell.webservices.models.StoreItemAction;
import com.luketowell.webservices.repositories.StoreItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/id/{id}")
    public StoreItem findStoreItemById(@PathVariable Long id){
        return storeItemRepository.findById(id)
                .orElseThrow(() -> new StoreItemNotFoundException(id));
    }

    @GetMapping("/store/{storeId}")
    public List<StoreItem> allStoreItemsForStore(@PathVariable String storeId){
        return storeItemRepository.findByStoreId(storeId);
    }

    @PostMapping("/item/action")
    @ResponseStatus(HttpStatus.CREATED)
    public StoreItem updateStoreItem(@RequestBody StoreItem body){
        var id = body.getId();
        var storeItem = storeItemRepository.findById(id)
                .orElseThrow(() -> new StoreItemNotFoundException(id));


        storeItem.setUpdated_date(body.getUpdated_date());
        storeItem.setActions(body.getActions());

        return storeItemRepository.save(storeItem);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public StoreItem addStoreItem(@RequestBody StoreItem body){
        return storeItemRepository.save(body);
    }
}
