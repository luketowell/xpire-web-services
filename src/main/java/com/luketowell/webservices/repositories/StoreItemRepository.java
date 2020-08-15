package com.luketowell.webservices.repositories;

import com.luketowell.webservices.models.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {


    public List<StoreItem> findByStoreId(String StoreId);
}
