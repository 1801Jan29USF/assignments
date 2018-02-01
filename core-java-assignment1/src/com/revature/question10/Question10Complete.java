package com.revature.question10;

public class Question10Complete {
	public static void main(String[] args) {
		int num1 = 20;
		int num2 = 5;
		
		// Using a ternary operator, finds the minimum of the two hard-coded
		// integers.
		int min = (num1 < num2) ? num1 : num2;
		
		System.out.println("The minimum of 20 and 5 is: " + min);
	}
}
