package com.luketowell.webservices.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "store_item")
public class StoreItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="item_upc")
    private String item_upc;

    @Column(name="store_id")
    private String store_id;

    public StoreItem() {
    }

    public StoreItem(Long id, String item_upc, String store_id) {
        this.id = id;
        this.item_upc = item_upc;
        this.store_id = store_id;
    }
}
