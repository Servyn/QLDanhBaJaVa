package com.example;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        Contact ct1 = new Contact("Cường",
                "0123456789",
                "caocuong@gmail.com",
                "HCM");
        Contact ct2 = new Contact("Cường2",
                "1123456789",
                "caocuong1@gmail.com",
                "HCM");
        ContactManager ql1 = new ContactManager();
        FileHandler fh1 = new FileHandler();
        ql1.addContact(ct1);
        ql1.addContact(ct2);
        ql1.showdanhba();
        System.out.println("_______________");
        fh1.fileToDanhba(ql1.danhba);
        ql1.showdanhba();
        for (Contact c: ql1.danhba){
            System.out.println("ID : " + c.getId() + " Tên : " + c.getName());
        }
    }
}