package com.company;

import java.util.Scanner;

public class Konzola {
	static Scanner kb = new Scanner(System.in);
	
	public static void printMenu(){
		System.out.println("1 - Pridat poznamku");
		System.out.println("2 - Upravit");
		System.out.println("3 - Odstranit");
		System.out.println("4 - O programe");
		System.out.println("5 - Vlastnosti");
		System.out.println("0 - Ukoncit");
	}
	public static int chooseAction(){
		return getNumFromTo("Vyber akciu: ", 0, 5, "Vyber položku z menu");
	}

    public static void print(String print){
        System.out.println(print);
    }

    public static void printHello(){
        System.out.println("Vitaj!");
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
            }
        }
        return out;
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

            }

        }
        return out;
    }

}
