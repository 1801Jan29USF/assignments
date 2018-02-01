package com.revature.question6;

public class Question6Complete {
	public static void main(String[] args) {
		
		// Declares 2 example ints and uses the checker functions implemented below
		int num = 6;
		int num2 = 13;
		
		evenChecker(num);
		evenChecker(num2);
		
	}
	
	// My method to check if the input number is even. Utilizes
	// division to complete the check
	public static void evenChecker(int num) {
		if((num/2)*2 == num) {
			System.out.println("The input number is even");
		} else {
			System.out.println("The input number is odd");
		}
	}
}
