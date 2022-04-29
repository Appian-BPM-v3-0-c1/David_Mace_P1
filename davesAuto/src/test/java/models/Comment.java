package models;

public class Comment {
    int customerId;
    String comments;

    public Comment() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Comment(int customer_id, String comments) {
        this.customerId = customer_id;
        this.comments = comments;
    }
}