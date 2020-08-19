package com.luketowell.webservices.repositories;

import com.luketowell.webservices.models.StoreItemSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

public interface StoreItemSummaryRepository extends JpaRepository<StoreItemSummary, Long> {

    List<StoreItemSummary> getStoreItemsByCategoryAndStoreId(@Param("categoryId") Long categoryId, @Param("storeId") String storeId);
}
