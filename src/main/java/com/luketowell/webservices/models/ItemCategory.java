package com.luketowell.webservices.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="item_category")
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="image_url")
    private String image_url;

    @OneToMany(mappedBy = "category")
    private Set<Item> items;

    public ItemCategory() {
    }

    public ItemCategory(Long id, String name, String image_url) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
