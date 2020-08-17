package com.luketowell.webservices.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="store")
public class Store {

    @Id
    @Column(name="id")
    private String value;

    @Column(name="name")
    private String label;

    public Store() {
    }

    public Store(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
