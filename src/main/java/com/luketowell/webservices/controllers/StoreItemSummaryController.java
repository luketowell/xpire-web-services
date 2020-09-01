package com.luketowell.webservices.controllers;

import com.luketowell.webservices.models.StoreItemSummary;
import com.luketowell.webservices.repositories.StoreItemSummaryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("storeitemsummary")
public class StoreItemSummaryController {

    StoreItemSummaryRepository storeItemSummaryRepository;

    public StoreItemSummaryController(StoreItemSummaryRepository storeItemSummaryRepository) {
        this.storeItemSummaryRepository = storeItemSummaryRepository;
    }

    @GetMapping("/{storeId}/{categoryId}")
    public List<StoreItemSummary> findAllItemsForStoreByCategory
            (@PathVariable String storeId, @PathVariable Long categoryId) {
        return storeItemSummaryRepository.getStoreItemsByCategoryAndStoreId( categoryId,storeId);
    }

    @GetMapping("findItem/{storeId}/{itemUpc}")
    public List<StoreItemSummary> findAllItemsForStoreByCategory
            (@PathVariable String storeId, @PathVariable String itemUpc) {
        return storeItemSummaryRepository.getStoreItemsByItemUpcAndStoreId( itemUpc,storeId);
    }
}
