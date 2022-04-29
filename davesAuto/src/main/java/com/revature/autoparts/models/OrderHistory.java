package com.revature.autoparts.models;

public class OrderHistory {
    int id;
    String date;
    int customer_id;
    int item_id;
    int shop_Loc;

    public OrderHistory () {
    }


    @Override
    public String toString() {
        return "OrderHistory{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", customer_id=" + customer_id +
                ", item_id=" + item_id +
                ", shop_Loc=" + shop_Loc +
                '}';
    }

    public OrderHistory (int id, String date, int customer_id, int item_id, int shop_Loc) {
        this.id = id;
        this.date = date;
        this.customer_id = customer_id;
        this.item_id = item_id;
        this.shop_Loc = shop_Loc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getShop_Loc() {
        return shop_Loc;
    }

    public void setShop_Loc(int shop_Loc) {
        this.shop_Loc = shop_Loc;
    }



}
