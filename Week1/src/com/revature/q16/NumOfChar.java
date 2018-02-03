package com.revature.q16;

import java.util.Scanner;

public class NumOfChar {

	public static void main(String[] args) {
		Scanner str = new Scanner (System.in);
		System.out.println("Enter String: ");
		String str1 = str.next(); 
		String spChar[] = str1.split("\\s");
		int strChar = str1.length();
	
		

		System.out.println("Number of character in string are " +strChar );
		
	}
}
