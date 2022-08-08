package com.example.myapplication;

public class Users {
    private String Uid,Name,Email,Password,Cpassword,PhoneNumber,Address;
    private Integer usertype1;

    public Users(){

    }

    private Users(String name, String email, String password, String cpassword, String phoneNumber, String address){
        Name = name;
        Email = email;
        Password = password;
        Cpassword= cpassword;
        PhoneNumber = phoneNumber;
        Address = address;

    }


    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCpassword() {
        return Cpassword;
    }

    public void setCpassword(String cpassword) {
        Cpassword = cpassword;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
