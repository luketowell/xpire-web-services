package com.luketowell.webservices.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="store_item_action")
public class StoreItemAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="action_id")
    private Long id;

    @Column(name="store_item_id")
    private Long store_item_id;

    @Column(name="user_id")
    private String user_id;

    @Column(name="status_id")
    private Long status_id;

    @Column(name="expired_count")
    private Long expired_count;

    @Column(name="update_date")
    private Date update_date;

    public StoreItemAction() {
    }

    public StoreItemAction(Long id, Long store_item_id, String user_id, Long status_id, Long expired_count, Date update_date) {
        this.id = id;
        this.store_item_id = store_item_id;
        this.user_id = user_id;
        this.status_id = status_id;
        this.expired_count = expired_count;
        this.update_date = update_date;
    }
}
