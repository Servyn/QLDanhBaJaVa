package com.example;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        Contact ct1 = new Contact("Cường",
                "0123456789",
                "caocuong@gmail.com",
                "HCM");
        ContactManager ql1 = new ContactManager();
        FileHandler fh1 = new FileHandler();
        ql1.addContact(ct1);
        fh1.fileToDanhba(ql1.danhba);
        ql1.showdanhba();
        Contact ct2 = ql1.searchContactEmail("caocuong3@gmail.com");
        ct2.setPhone("0905486544");
        ql1.showdanhba();
    }
}