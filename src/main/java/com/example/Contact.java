package com.example;

public class Contact {
     private String name;
     private String phone;
     private String email;
     private String address;
     private static int nextInt = 1;
     private int id ;

    public Contact(String name, String phone, String email, String address) {
        this.id = nextInt++;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "Tên : " + name + '\t' +
                ", SĐT : " + phone + '\t' +
                ", Email : " + email + '\t' +
                ", Địa Chỉ : " + address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
