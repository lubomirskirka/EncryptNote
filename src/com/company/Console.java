package com.company;

import risko.MSave;
import risko.MSaveEncrypt;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
	static Scanner kb = new Scanner(System.in);
	
	public static void printMenu(){
		System.out.println("1 - Show notes");
		System.out.println("2 - Show note detail");
        System.out.println("3 - Add note");
		System.out.println("3 - Odstranit poznamku");
		System.out.println("4 - Zmenit heslo");
		System.out.println("5 - Vlastnosti");
		System.out.println("0 - Ukoncit");
	}

	public static void printNote(){
	    int indexOfNote = getNumFromTo("Write number of note or 0 for exit: ",0,Main.notes.size(), "Note don't exist");
        Note note = Main.notes.get(indexOfNote-1);
        System.out.println("Poznámka: ");
        System.out.println(note.getPoznamka());
        blank(1);
        System.out.println("Dátum a čas vytvorenia:" + note.getDatum()+ " " + note.getCas());
        enterToContinue();
        blank(3);
    }

    public static void enterToContinue()
    {
        Scanner enter = new Scanner(System.in);
        enter.nextLine();
    }

	public static void printNotes(ArrayList<Note> notes){
	    for (int i = 0; i < notes.size(); i++){
	        System.out.println((i + 1) + ". " + notes.get(i).getPoznamka());
        }
        blank(1);
    }

	public static int chooseAction(){
		return getNumFromTo("Vyber akciu: ", 0, 5, "Vyber položku z menu");
	}

    public static void print(String print){
        System.out.println(print);
    }

    public static String printHello(){
        System.out.println("Vitaj!");
        return Console.getPassword("Password: ");
    }


    public static String getPassword(String what){
        String in;

        while (true) {
            in = getString(what);
            MSaveEncrypt m = new MSaveEncrypt("data",in);
            try {
                if ("GodIsGood".equals(m.read(0)))
                    return in;
            }
            catch (org.jasypt.exceptions.EncryptionOperationNotPossibleException e){
                System.out.print("Wrong password");
                enterToContinue();
            }

        }
    }

    public static int getNumFromTo(String what, int from, int to, String error)
    {
        int out;
        while (true)
        {
            out = getNum(what);
            if (out >= from && out <= to)
                break;
            else
            {
                System.out.print(error);
                enterToContinue();
            }
        }
        return out;
    }

    public static String getString(String what){
        Scanner scanner = new Scanner(System.in);
        print(what);
        return scanner.nextLine();
    }

    public static void blank(int num)
    {
        for (int i = 0; i < num;i++)
            System.out.println();
    }

    public static int getNum(String what)
    {
        int out = 0;
        while (true)
        {
            Scanner kb9 = new Scanner(System.in);
            System.out.print(what);
            try
            {
                out = kb9.nextInt();
                break;
            }
            catch (Exception e)
            {
                System.out.print("Wrong input");
                enterToContinue();
            }

        }
        return out;
    }

}
