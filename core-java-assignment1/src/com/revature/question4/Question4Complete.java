package com.revature.question4;

import java.util.Scanner;

public class Question4Complete {
	public static void main(String[] args) {
		
		// Creating a scanner to allow user input
		Scanner scan = new Scanner(System.in);
		
		// the number that was contain the eventual n factorial
		int factorial = 1;
		System.out.println("Input the number you would like to know the factorial of: ");
		// Placing the users input into an index number that determines
		// how many times the for loop will iterate.
		int num = scan.nextInt();
		
		// A for loop that determines the factorial of the input number.
		for(int i = 1; i <= num; i++) {
			factorial = factorial * i;
		}
		System.out.println("The factorial of " + num + " is " + factorial);
		scan.close();
	}
}