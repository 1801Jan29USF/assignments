package com.revature.question14;

import java.util.Date;

public class Question14Complete {
	public static void main(String[] args) {
		// I use an int to change which switch is used.
		// In order to demonstrate that every function in my switch
		// works, I copied and pasted it 3 times, and 
		// in the case that is used, switch the num 
		// to the one required for the next case.
		int num = 1;
		
		switch (num) {
		case 1:
			System.out.println(Math.sqrt(16));
			num = 2;
			break;

		case 2:
			Date d = new Date();
			System.out.println(d.toString());
			break;
			
		case 3:
			String s = "I am learning Core Java";
			String[] arr = s.split(" ");
			for (String s1 : arr) {
				System.out.println(s1);
			}
			break;

		default:
			System.out.println("Hello, how are you?");
			break;
		}
		
		switch (num) {
		case 1:
			System.out.println(Math.sqrt(16));
			break;

		case 2:
			Date d = new Date();
			System.out.println(d.toString());
			num = 3;
			break;
			
		case 3:
			String s = "I am learning Core Java";
			String[] arr = s.split(" ");
			for (String s1 : arr) {
				System.out.println(s1);
			}
			break;

		default:
			System.out.println("Hello, how are you?");
			break;
		}
		
		switch (num) {
		case 1:
			System.out.println(Math.sqrt(16));
			break;

		case 2:
			Date d = new Date();
			System.out.println(d.toString());
			break;
			
		case 3:
			String s = "I am learning Core Java";
			String[] arr = s.split(" ");
			for (String s1 : arr) {
				System.out.println(s1);
			}
			break;

		default:
			System.out.println("Hello, how are you?");
			break;
		}
	}
}