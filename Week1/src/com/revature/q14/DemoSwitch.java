package com.revature.q14;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DemoSwitch {
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	System.out.println("Please select an option: ");
	System.out.println("Enter 1 to find Squareroot of a number");
	System.out.println("Enter 2 to Display today's date");
	System.out.println("Enter 3 to split string ");
	
	
	String cases = scan.nextLine();
	switch (cases) {
	case "1":
		Scanner number = new Scanner(System.in);
		System.out.println("enter number to find square root");
		int num = number.nextInt();
		//Math.sqrt(num);
		System.out.println(Math.sqrt(num));
		
		break;
		
	case "2":;
	
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 LocalDateTime dt =  LocalDateTime.now();
		 System.out.println(f.format(dt));

		break;	
		
	case "3":;
//	Scanner strings = new Scanner(System.in);
//	System.out.println("enterString");
	String line1 = "I am learning Core Java";
	String[] line2 = line1.split("\\s");
	System.out.println(line2);
	
		break;
	
	
	default:
		break;
	}

}
}
