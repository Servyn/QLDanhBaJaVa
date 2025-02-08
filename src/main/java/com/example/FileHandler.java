package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FileHandler {
    private String fileName = "danhba.txt";
    public void danhbaToFile(ArrayList<Contact> danhba) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            for ( Contact pt : danhba){
                bw.write(pt.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void backupDanhBa() {
        String backupFileName = "backup_danhba.txt"; // Tên file backup
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            BufferedWriter bw = new BufferedWriter(new FileWriter(backupFileName));

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine(); // Xuống dòng
            }

            br.close();
            bw.close();

            System.out.println("Backup danh bạ thành công vào " + backupFileName);
        } catch (IOException e) {
            System.out.println("Backup thất bại!");
            e.printStackTrace();
        }
    }
    public ArrayList<Contact> fileToDanhba(ArrayList<Contact> danhba) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");

                String name = txt[0].substring(txt[0].indexOf(":") + 1).trim();
                String phone = txt[1].substring(txt[1].indexOf(":") + 1).trim();
                String email = txt[2].substring(txt[2].indexOf(":") + 1).trim();
                String address = txt[3].substring(txt[3].indexOf(":") + 1).trim();

                boolean updated = false;
                for (Contact c : danhba){
                    if (c.getName().equals(name)) {
                        if (c.getPhone().equals(phone)) {
                            c.setEmail(email);
                            c.setAddress(address);
                            updated = true;
                            break;
                        } else if (c.getEmail().equals(email)) {
                            c.setPhone(phone);
                            c.setAddress(address);
                            updated = true;
                            break;
                        }
                    }
                }
                if (!updated){
                    danhba.add(new Contact(name,phone,email,address));
                }
            }

            br.close();
            fr.close();

            // Xóa Contact trùng trong danh bạ chính


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return danhba;
    }

}
