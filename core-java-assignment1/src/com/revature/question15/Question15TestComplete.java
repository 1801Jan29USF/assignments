package com.revature.question15;

public class Question15TestComplete {
	public static void main(String[] args) {
		// My test class, has two hardcoded ints that are passed to my implemented interface.
		Question15Implementer obj = new Question15Implementer();
		int num1 = 10;
		int num2 = 15;
		
		System.out.println("The addition of 10 and 15 is: " + obj.addition(num1, num2));
		System.out.println("The subtraction of 10 and 15 is: " + obj.subtraction(num1, num2));
		System.out.println("The multiplication of 10 and 15 is: " + obj.multiplication(num1, num2));
		System.out.println("The division of 10 and 15 is: " + obj.division(num1, num2));
	}
}
