package com.revature.autoparts.models;

public class ShoppingCart {
    int id;
    int quantity;
    int item_id;
    int customer_id;

    public ShoppingCart() {
    }

    public ShoppingCart(int id, int quantity, int item_id, int customer_id) {
        this.id = id;
        this.quantity = id;
        this.item_id = item_id;
        this.customer_id = customer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", item_id=" + item_id +
                ", customer_id=" + customer_id +
                '}';
    }
}