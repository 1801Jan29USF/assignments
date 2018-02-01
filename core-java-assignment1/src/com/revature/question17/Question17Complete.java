package com.revature.question17;

import java.util.Scanner;

public class Question17Complete {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		// My inputs used that are input by the user through scanner
		double principal = 0;
		double time = 0;
		double rate = 0;
		// Declaring a scanner object
		Scanner scan = new Scanner(System.in);
		
		// Each of these 3 lines of code displays a line to prompt the user
		// which number to input, then takes the input number for the user
		// and, using the Scanner object, places it into the corresponding
		// number.
		System.out.println("Please enter the principal: ");
		Double input = scan.nextDouble();
		principal = input;
		
		System.out.println("Please enter the number of years: ");
		input = scan.nextDouble();
		time = input;
		
		System.out.println("Please enter rate of interest: ");
		input = scan.nextDouble();
		rate = input;
		
		// The interest is now printed.
		System.out.println("Your interest is: " + principal * time * rate);
	}
}