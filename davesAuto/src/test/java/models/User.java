package models;

public class User {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private int storeLocId;


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", storeLocId=" + storeLocId +
                '}';
    }

    public User(int id, String username, String firstName, String lastName, String emailAddress, String password, int storeLocId) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName =lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.storeLocId = storeLocId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStoreLocId() {
        return storeLocId;
    }

    public void setStoreLocId(int storeLocId) {
        this.storeLocId = storeLocId;
    }

}
