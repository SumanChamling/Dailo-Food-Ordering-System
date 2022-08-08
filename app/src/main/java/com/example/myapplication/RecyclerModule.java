package com.example.myapplication;

public class RecyclerModule {
    String name,address,website,phone;


    public RecyclerModule(){

    }

    public RecyclerModule(String name, String address, String website, String phone) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
