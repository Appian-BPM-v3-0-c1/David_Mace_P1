package com.revature.autoparts.models;

public class StoreLoc {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int locId;
    private String address;
    private String city;
    private String state;
    private String country;


    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public StoreLoc() {
    }

    @Override
    public String toString() {
        return "StoreLoc{" +
                "id=" + id +
                ", locId=" + locId +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public StoreLoc(int locId, String address, String city, String state, String country){
        this.locId = locId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }


}
