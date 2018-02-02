package com.revature.Q17;

import java.util.Scanner;

/*
 * Demonstrate Scanner 
 */
public class Scanna {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter principal, rate, and time to calculate interest:");

		System.out.println(calculateInterest(s.nextDouble(), s.nextDouble(), s.nextDouble()));
		s.close();
	}

	// Calculates interest by multiplying the 3 parameters
	public static double calculateInterest(double principal, double rate, double time) {
		{
			return principal * rate * time;
		}

	}

}
