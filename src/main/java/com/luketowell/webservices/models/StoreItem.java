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

    @Column(name="item_upc", updatable = false, insertable = false)
    private Long item_upc;

    @Column(name="store_id")
    private String storeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="item_upc")
    private Item item;

    @OneToMany(mappedBy = "store_item_id")
    private Set<StoreItemAction> actions;

    public StoreItem() {
    }

    public StoreItem(Long id, Long item_upc, String storeId) {
        this.id = id;
        this.item_upc = item_upc;
        this.storeId = storeId;
    }

    public StoreItem(Long id, Item item, String store_id) {
        this.id = id;
        this.item = item;
        this.storeId = store_id;
    }
}
