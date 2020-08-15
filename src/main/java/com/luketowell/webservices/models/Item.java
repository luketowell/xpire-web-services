package com.luketowell.webservices.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="item")
public class Item {

    @Id
    @Column(name="upc")
    private String upc;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="expiry")
    private Date expiry;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private ItemCategory category ;

    @Column(name="size")
    private String size;

    @Column(name="img_url")
    private String img_url;

    public Item() {
    }

    public Item(String upc, String name, String description, Date expiry, ItemCategory category, String size, String img_url) {
        this.upc = upc;
        this.name = name;
        this.description = description;
        this.expiry = expiry;
        this.category = category;
        this.size = size;
        this.img_url = img_url;
    }
}
