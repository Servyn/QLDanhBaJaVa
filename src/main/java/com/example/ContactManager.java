package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    Scanner sc = new Scanner(System.in);
    ArrayList<Contact> danhba = new ArrayList<>();

    public ArrayList<Contact> getDanhba() {
        return danhba;
    }

    public void addContact(Contact contact){
        danhba.add(contact);
    }
    public void showdanhba(){
        for (Contact c : danhba){
            System.out.println(c.toString());
        }
    }

    public Contact searchContact(String info){
        for (Contact c : danhba){
            if (c.getPhone().equals(info)){
                return c;
            } else if (c.getEmail().equals(info)) {
                return c;
            } else if (c.getName().equals(info)) {
                return c;
            }
        }
        return null;
    }
    public void deleteContact(Contact contact){
        danhba.remove(contact);
    }
    public void changeSDT (int id, String change){
        for (Contact c : danhba){
            if (c.getId() == id){
                c.setPhone(change);
            }
        }
    }
    public void changeEmail (int id, String change){
        for (Contact c : danhba){
            if (c.getId() == id){
                c.setEmail(change);
            }
        }
    }
}
