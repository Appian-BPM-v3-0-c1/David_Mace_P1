package models;

public class Item {
    String comments;
    String itemName;
    int id;
    int stock;
    int deptId;
    int quantity;
    float itemPrice;

    public Item () {
    }

    public Item(String comments, String itemName, int id, int stock, int deptId, int quantity, int itemPrice) {
        this.comments = comments;
        this.itemName = itemName;
        this.id = id;
        this.stock = stock;
        this.deptId = deptId;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getDesiredQuantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return
                "{itemName='" + itemName + '\'' +
                        ", id=" + id +
                        ", stock=" + stock +
                        ", deptId=" + deptId +
                        ", quantity=" + quantity +
                        ", itemPrice=" + itemPrice + "}";
    }
}
