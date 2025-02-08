package com.example;

import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager ql1 = new ContactManager();
        FileHandler fh1 = new FileHandler();
        Menu mn = new Menu();
        fh1.fileToDanhba(ql1.danhba);
        int choice;
        do{
            mn.showMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1: {
                    ql1.showdanhba();
                    break;
                }
                case 2: {
                    ql1.addContact();
                    fh1.danhbaToFile(ql1.danhba);
                    break;
                }
                case 3 : {
                    ql1.changeSDT();
                    fh1.danhbaToFile(ql1.danhba);
                    break;
                }
                case 4 : {
                    ql1.deleteContact();
                    fh1.danhbaToFile(ql1.danhba);
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("không hợp lệ.");
                    break;
            }
        }while (choice != 0);
    }
}