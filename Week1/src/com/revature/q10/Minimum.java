package com.revature.q10;

import java.util.Scanner;

public class Minimum {
	public static void main(String[] args) {
		Scanner number1 = new Scanner (System.in);
		System.out.println("Enter the first number: ");
		int num1 = number1.nextInt();
		Scanner number2 = new Scanner (System.in);
		System.out.println("Enter the second number: ");
		int num2 = number2.nextInt();
		
		int minimumOfTwo = (num1 > num2 ) ? num2 : num1; //if num1 is greater, prints num2
		System.out.println("Minumn number of the two number you entered is: " + minimumOfTwo);
		
		
	}

}
