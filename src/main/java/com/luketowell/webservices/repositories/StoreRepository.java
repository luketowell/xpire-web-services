package com.luketowell.webservices.repositories;

import com.luketowell.webservices.models.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository <Store, String> {

}
