package com.company;

import java.util.ArrayList;

public class Main {
    static ArrayList<Note> notes;
    static Database database;

    public static void main(String[] args) {
        String password;
        if (!Database.exist()){
            password = Console.getString("Your new password: ");
        }
        else{
            password = Console.printHello();
        }
        database = new Database(password);
        notes = database.readNotes();
        while (true){
            Console.blank(1);
            Console.printMenu();
            switch (Console.chooseAction()){
                case 1:
                    Console.printNotes(notes);
                    Console.enterToContinue();
                    break;
                case 2:
                    Console.printNote();
                    break;
                case 3:
                    addNote();
                    break;
                case 0:
                    exit();
                    break;
            }
        }
    }

    public static void exit(){
        System.exit(0);
    }

    public static void addNote(){
        notes.add(new Note(Console.getString("Write your note: ")));
        database.updateNotes(notes);
    }


}
