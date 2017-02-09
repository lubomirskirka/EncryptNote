package com.company;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.util.ArrayList;

public class Main {
    static ArrayList<Note> notes;

    public static void main(String[] args) {
        Database database = new Database();
        notes = database.readNotes();
        Konzola.printHello();
        while (true){
            Konzola.blank(1);
            Konzola.printMenu();
            switch (Konzola.chooseAction()){

            }
        }
    }
}
