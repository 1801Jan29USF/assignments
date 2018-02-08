package com.revature.question17;

import java.util.Scanner;

public class ScannerStuff {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float rate;
		int principal, time;
		System.out.println("Enter the principal: ");
		// I thought you said to avoid nextInt() and such but I'm not sure what else to use to read an integer
		principal = scan.nextInt();
		System.out.println("Enter the time: ");
		time = scan.nextInt();
		System.out.println("Enter the rate: ");
		rate = scan.nextFloat();
		
		// No need to store interest in this case
		System.out.println("Interest is: " + (principal * rate * time));
		
		
	}
}
