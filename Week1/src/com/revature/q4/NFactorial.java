package com.revature.q4;

import java.util.Scanner;

public class NFactorial {

	public static void main(String args[]) {
		
		Scanner number= new Scanner(System.in); 
		System.out.println("enter the number for n: ");
		int n = number.nextInt();
		
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial = factorial * i; 
		}
		System.out.println("factorial of " + n + " is " + factorial);
	}

}
