package com.revature.q20;
import java.util.Scanner;
import java.io.*;

public class ReadFromFile {

	//public static void main(String[] args) throws Exception {
	public static void main(String[] args) {
		
		
		
		System.out.println("Name: "  );
		System.out.println("Age: "  );
		System.out.println("State: "  );
		
		
		
	}
		
		public void readLetter (char l) {
	try (FileReader fr = new FileReader("Data.txt")){
		fr.read();
		}
	catch (FileNotFoundException e) {
		System.out.println("unable to wtite a file fo");
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

			
		}
		

		
}

		
	
		
