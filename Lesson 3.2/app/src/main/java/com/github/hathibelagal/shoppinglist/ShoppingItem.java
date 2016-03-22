package com.github.hathibelagal.shoppinglist;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Hathi on 13/3/16.
 */
public class ShoppingItem extends RealmObject {

    private String name;
    private String quantity;
    private boolean completed;

    @PrimaryKey
    private String id;

    private long timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
