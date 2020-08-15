package com.luketowell.webservices.controllers;

import com.luketowell.webservices.error.ItemNotFoundException;
import com.luketowell.webservices.models.Item;
import com.luketowell.webservices.repositories.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class ItemController {

    ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/{id}")
    public Item findItemById(@PathVariable String id){
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Item insertNewItem(@RequestBody Item item){
       return itemRepository.save(item);
    }
}
