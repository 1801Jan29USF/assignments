package com.revature.HW1.Q10;

import java.util.Scanner;

public class MinTernary {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter integer a: "); // User enters first integer
		int a = scan.nextInt();
		System.out.println("Enter integer b: "); // User enters second integer
		int b = scan.nextInt();

		int minval = (a < b) ? a : b; // if a is less than b, minval = a, otherwise minval = b.

		System.out.println("The minimum value is " + minval + ".");
	}

}
