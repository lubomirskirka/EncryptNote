package com.company;

import risko.MSave;
import risko.MSaveEncrypt;

import java.util.ArrayList;

import static com.company.Main.notes;


public class Database extends risko.MSaveEncrypt {
    public Database(String password){
        super("data", password);
        if (!exists()){
            createFile();
        }
    }

    public static boolean exist(){
        return new MSave("data").exists();
    }

    public ArrayList<Note> readNotes(){
        ArrayList<Note> notes = new ArrayList<>();

        for (int i = 1; i < fileLength(); i++){
            String[] line = read(i).split(";");

            if (line.length == 2){
                try {
                    notes.add(new Note(line[0],Long.parseLong(line[1])));
                }
                catch (NumberFormatException e){
                    System.out.println("Error 13");
                }
            }
            else{
                System.out.println("Error 15");
            }
        }

        return notes;
    }

    public void updateNotes(ArrayList<Note> notes){
        deleteFile();
        createFile();
        write(0,"GodIsGood");
        for (int i = 0; i < notes.size(); i++){
            String data = notes.get(i).getPoznamka() + ";" + notes.get(i).getSecond();
            write(i+1,data);
        }
    }

    public void updatePassword(String newPassword){
        deleteFile();
        createFile();
        setPassword(newPassword);
        write(0,"GodIsGood");
        for (int i = 0; i < notes.size(); i++){
            String data = notes.get(i).getPoznamka() + ";" + notes.get(i).getSecond();
            write(i+1,data);
        }

    }


}
