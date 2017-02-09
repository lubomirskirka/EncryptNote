package com.company;

import java.util.Scanner;

public class Konzola {
	static Scanner kb = new Scanner(System.in);
	
	public static void vypisMenu(){
		System.out.println("1 - Pridat poznamku");
		System.out.println("2 - Upravit");
		System.out.println("3 - Odstranit");
		System.out.println("4 - O programe");
		System.out.println("5 - Vlastnosti");
		System.out.println("0 - Ukoncit");
	}
	public static char vyberAkciu(){
		System.out.print("Vyber akciu: ");
		String a = kb.nextLine();
		return ' ';
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
    public static void enterToContinue()
    {
        Scanner enter = new Scanner(System.in);
        enter.nextLine();
    }
}
