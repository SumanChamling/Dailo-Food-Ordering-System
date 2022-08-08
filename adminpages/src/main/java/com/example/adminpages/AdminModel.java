package com.example.adminpages;

public class AdminModel {
    private Integer id , lat, lng;
    private String hName,hAddress,hWebsite;

    public AdminModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String gethAddress() {
        return hAddress;
    }

    public void sethAddress(String hAddress) {
        this.hAddress = hAddress;
    }

    public String gethWebsite() {
        return hWebsite;
    }

    public void sethWebsite(String hWebsite) {
        this.hWebsite = hWebsite;
    }
}
