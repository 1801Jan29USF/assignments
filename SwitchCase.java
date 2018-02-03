//Q14
package com.revature.switches;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.revature.compareter.Main;

public class SwitchCase {

	public static void main (String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please select an option: ");
		System.out.println("Enter 1 Find the square root of a number");
		System.out.println("Enter 2 to display today's date");
		System.out.println("Enter 3 to store a string in a array");
		String input = scan.nextLine();
		switch (input) {
		case "1":
			
			System.out.println("Enter a number");
			Integer num = scan.nextInt();
			System.out.println(Math.sqrt(num));
			
			
			break;
		case "2":
			
			DateFormat dateForm = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateForm.format(date));
			
			
			break;
		case "3":
			
			String s1 = "I am learning Core Java";
			String[] items = s1.split(" ");
			for (int i = 0; i < items.length; i++) {
				System.out.println(items[i]);
				
			}
			
			
			
			break;
		
		default:
			break;
		}

	}

}
