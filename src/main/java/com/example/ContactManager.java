package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ContactManager {
    Scanner sc = new Scanner(System.in);
    ArrayList<Contact> danhba = new ArrayList<>();

    public ArrayList<Contact> getDanhba() {
        return danhba;
    }
    private boolean invalidMessage(String message) {
        System.out.println(message);
        return true;
    }
    public void addContact(){
        System.out.println("Mời nhập các thông tin : ");
        System.out.println("Nhập tên: ");
        String name = sc.nextLine().trim();
        String phone;
        do {
            System.out.println("Nhập số điện thoại : ");
            phone = sc.nextLine().trim();
        }while (!phone.matches("\\d{10}") || invalidMessage("SDT không hợp lệ."));
        String email;
        do {
            System.out.println("Nhập Email : ");
            email = sc.nextLine().trim();

        }while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") && invalidMessage("Email không hợp lệ"));
        System.out.println("Nhập Địa chỉ : ");
        String address = sc.nextLine().trim();
        Contact contact = new Contact(name,phone,email,address);
        for (Contact c : danhba){
            if (c.getPhone().equals(contact.getPhone()) || c.getEmail().equals(contact.getEmail()))
            {
                System.out.println("SDT/Email đã được sử dụng");
                return;
            }
        }
        danhba.add(contact);
        System.out.println("Thêm liên hệ thành công");

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
    public void deleteContact(){
        String email;
        boolean found = false;
        do {
            System.out.println("Mời nhập Email : ");
            email = sc.nextLine().trim();
        }while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") && invalidMessage("Email không hợp lệ"));
        Iterator <Contact> iterator = danhba.iterator();
        while (iterator.hasNext()){
            Contact c = iterator.next();
            if (c.getEmail().equals(email)){
                iterator.remove();
                found = true;
                System.out.println("Xóa thành công");
                break;
            }
        }
        if (!found){
            System.out.println("Không có email này trong danh bạ");
        }
    }
    public void changeSDT (){
        String email;
        boolean found = false;
        do {
            System.out.println("Mời nhập Email : ");
            email = sc.nextLine().trim();
        }while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") && invalidMessage("Email không hợp lệ"));
//        for (Contact c : danhba){
//            if (c.getEmail().equals(email)) {
//                found = true;
//                String phone;
//                do {
//                    System.out.println("Nhập số điện thoại mới: ");
//                    phone = sc.nextLine().trim();
//                }while (!phone.matches("\\d{10}") && invalidMessage("SDT không hợp lệ."));
//                boolean phoneExist = false;
//                for (Contact contact : danhba){
//                    if (contact.getPhone().equals(phone)){
//                        phoneExist = true;
//                        break;
//                    }
//                }
//                if (phoneExist){
//                    System.out.println("SDT đã tồn tại.");
//                    break;
//                }else {
//                    c.setPhone(phone);
//                    System.out.println("Cập nhật sdt thành công.");
//                    return;
//                }
//            }
//        }
        for (Contact c : danhba){
            if (c.getEmail().equals(email)){
                found = true;
                String phone;
                while (true){
                    System.out.println("Mời nhập SDT mới : ");
                    phone = sc.nextLine().trim();
                    if (!phone.matches("\\d{10}")){
                        System.out.println("SDT không hợp lệ. mời nhập lại");
                        continue;
                    }
                    boolean phoneExist = false;
                    for (Contact contact: danhba){
                        if (contact.getPhone().equals(phone)){
                            phoneExist = true;
                            break;
                        }
                    }
                    if (phoneExist){
                        System.out.println("SDT đã tồn tại , mời nhập lại");
                        continue;
                    }
                    else {
                        c.setPhone(phone);
                        System.out.println("Cập nhật sdt thành công");
                        return;
                    }
                }
            }
        }
        if (!found){
            System.out.println("Không có email này trong danh bạ");
        }
    }
}
