package com.revature.question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Switcheroo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a valid value: ");
		String input = scan.nextLine();
		
		switch (input) {
		case "1":
			System.out.println("Enter an integer: ");
			int num = scan.nextInt();
			double result = Math.sqrt(num);
			System.out.println(result);
			break;
		case "2":
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
		case "3":
			// Do you have a preference of creating variables at the top or
			// making them just above where they will be used?
			String str = "I am learning core java";
			String[] strArray = new String[3];
			
			// You say to split it, but not how you want it split so I'm just going to carve it up into 3 arbitrary chunks
			strArray[0] = str.substring(0, str.length()/3);
			strArray[1] = str.substring(str.length()/3, 2*(str.length()/3));
			strArray[2] = str.substring(2*(str.length()/3), str.length());
			for(String s : strArray) {
				System.out.println(s);
			}
			break;


		default:
			System.out.println("Wrong value");
			break;
		}
	}
}
