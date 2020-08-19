package com.luketowell.webservices.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SqlResultSetMapping(
        name = "storeItemCategoryMapping",
        classes = {
                @ConstructorResult(
                        targetClass = com.luketowell.webservices.models.StoreItemSummary.class,
                        columns = {
                                @ColumnResult(name = "id"),
                                @ColumnResult(name = "item_upc"),
                                @ColumnResult(name = "store_id"),
                                @ColumnResult(name = "name"),
                                @ColumnResult(name = "category_id"),
                                @ColumnResult(name = "img_url"),
                        }
                )
        }
)
@NamedNativeQuery(name = "StoreItemSummary.getStoreItemsByCategoryAndStoreId", query = "SELECT si.id, si.item_upc, si.store_id, i.name, i.category_id, i.img_url " +
        "FROM store_item si " +
        "INNER JOIN item i " +
        "ON si.item_upc = i.upc " +
        "WHERE i.category_id = :categoryId AND si.store_id =:storeId", resultSetMapping = "storeItemCategoryMapping")
public class StoreItemSummary {

    @Id
    private Integer id;
    private String item_upc;
    private String store_id;
    private String name;
    private Integer category_id;
    private String img_url;

    public StoreItemSummary() {
    }

    public StoreItemSummary(Integer id, String item_upc, String store_id, String name, Integer category_id, String img_url) {
        this.id = id;
        this.item_upc = item_upc;
        this.store_id = store_id;
        this.name = name;
        this.category_id = category_id;
        this.img_url = img_url;
    }
}
