package com.revature.Q20;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

/*
 * Interpreting a text file and tokenizing it to fit the format by using Scanner
 */
public class Notepad {
	public static void main(String[] args) {
		File text = new File("C:\\Users\\ricky\\eclipse-workspace\\Homework1\\src\\com\\revature\\Q20\\Data.txt");
		String str = "";
		try (Scanner s = new Scanner(text)) {
			while (s.hasNextLine()) {
				str = s.nextLine();
				String array1[] = str.split(":");
				System.out.println("Name: " + array1[0] + " " + array1[1]);
				System.out.println("Age: " + array1[2] + " years");
				System.out.println("State: " + array1[3]);
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
