package com.luketowell.webservices.repositories;

import com.luketowell.webservices.models.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {

    public List<StoreItem> findByStoreId(String StoreId);

}