package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FileHandler {
    private String fileName = "danhba.txt";
    public void danhbaToFile(ArrayList<Contact> danhba) {
        try {
            FileWriter fw = new FileWriter(fileName,true);
            BufferedWriter bw = new BufferedWriter(fw);
            for ( Contact pt : danhba){
                bw.write(pt.toString());
                bw.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Contact> fileToDanhba(ArrayList<Contact> danhba) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;

            ArrayList<Contact> tempList = new ArrayList<>(); // Danh sách tạm để chứa dữ liệu từ file

            while ((line = br.readLine()) != null) {
                String[] txt = line.split(",");
                String[] txt2 = new String[txt.length];

                for (int i = 0; i < txt.length; i++) {
                    txt2[i] = txt[i].substring(txt[i].indexOf(":") + 1).trim();
                }

                String name = txt2[0];
                String phone = txt2[1];
                String email = txt2[2];
                String address = txt2[3];

                Contact newContact = new Contact(name, phone, email, address);
                tempList.add(newContact); // Thêm vào danh sách tạm
            }

            br.close();
            fr.close();

            // Xóa Contact trùng trong danh bạ chính
            Iterator<Contact> it = danhba.iterator();
            while (it.hasNext()) {
                Contact pt = it.next();
                for (Contact newContact : tempList) {
                    if (pt.getName().equals(newContact.getName()) &&
                            (pt.getPhone().equals(newContact.getPhone()) || pt.getEmail().equals(newContact.getEmail()))) {
                        it.remove();  // Xóa contact trùng
                        break;
                    }
                }
            }

            // Thêm toàn bộ contact từ file vào danh bạ chính
            danhba.addAll(tempList);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return danhba;
    }

}
