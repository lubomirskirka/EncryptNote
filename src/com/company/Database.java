package com.company;

import java.util.ArrayList;



public class Database extends risko.MSaveEncrypt {
    public Database(){
        super("data", "test");
        if (!exists()){
            createFile();
        }
    }

    public ArrayList<Note> readNotes(){
        ArrayList<Note> notes = new ArrayList<>();

        for (int i = 0; i < fileLength(); i++){
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
        for (int i = 0; i < notes.size(); i++){
            String data = notes.get(i).getPoznamka() + ";" + notes.get(i).getSecond();
            write(i,data);
        }
    }


}
