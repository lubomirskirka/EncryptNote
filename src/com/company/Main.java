package com.company;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Note> notes = new ArrayList<>();

        notes.add(new Note("Ahoj"));
        notes.add(new Note("Hey"));

        Database database = new Database();
        database.updateNotes(notes);

        ArrayList<Note> read = database.readNotes();



        for (int i = 0; i < read.size(); i++){
            System.out.println(read.get(i).getPoznamka() + ";" + read.get(i).getSecond());
        }
    }
}
