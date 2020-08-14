package com.luketowell.webservices.controllers;

import com.luketowell.webservices.error.StatusNotFoundException;
import com.luketowell.webservices.models.Status;
import com.luketowell.webservices.repositories.StatusRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class StatusController {
    StatusRepository statusRepository;

    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @GetMapping("/all")
    public Iterable<Status> getAllStatus() {
       return statusRepository.findAll();
    }

    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable Long id){
        return statusRepository.findById(id)
                .orElseThrow(() -> new StatusNotFoundException(id));
    }
}
