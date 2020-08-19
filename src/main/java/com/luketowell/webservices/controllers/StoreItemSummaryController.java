package com.luketowell.webservices.controllers;

import com.luketowell.webservices.models.StoreItemSummary;
import com.luketowell.webservices.repositories.StoreItemSummaryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("storeItemSummary")
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
}
