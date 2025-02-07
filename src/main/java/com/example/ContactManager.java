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
    public Contact searchContactName(String info){
        for (Contact c : danhba){
            if (c.getName().equals(info)){
                return c;
            }
        }
        return null;
    }
    public Contact searchContactPhone(String info){
        for (Contact c : danhba){
            if (c.getPhone().equals(info)){
                return c;
            }
        }
        return null;
    }
    public Contact searchContactEmail(String info){
        for (Contact c : danhba){
            if (c.getEmail().equals(info)){
                return c;
            }
        }
        return null;
    }
    public void deleteContact(Contact contact){
        danhba.remove(contact);
    }
    public void changeSDT (String info, String change){
        for (Contact c : danhba){
            if (c.getEmail().equals(info)){
                c.setPhone(change);
            }
        }
    }
    public void changeEmail (String info, String change){
        for (Contact c : danhba){
            if (c.getPhone().equals(info)){
                c.setPhone(change);
            }
        }
    }
}
