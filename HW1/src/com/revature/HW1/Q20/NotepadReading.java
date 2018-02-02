package com.revature.HW1.Q20;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.*;

public class NotepadReading {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data.txt");
		System.out.println(file.getPath());
		Scanner scan = new Scanner(new FileInputStream("data.txt"));
		do { 
		scan.useDelimiter(":");
		System.out.print("\nName: " + scan.next() + " " + scan.next() ); //print a name along with next two tokens
		System.out.print("\nAge: " + scan.next() + " years"); // print age plus one token
		System.out.print("\nState" +  scan.nextLine() + " State"); //print state plus one token
		}
		while(scan.hasNext()); //until the scanner has no next line
	}

}
