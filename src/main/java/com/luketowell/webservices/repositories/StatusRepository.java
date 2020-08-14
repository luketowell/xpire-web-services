package com.luketowell.webservices.repositories;

import com.luketowell.webservices.models.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {
}
