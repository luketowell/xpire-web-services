package com.luketowell.webservices.repositories;

import com.luketowell.webservices.models.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {
}
