package com.revature.HW1.Q17;
import java.util.*;

/**
 * @author Brandon
 * Prompts the user for numeric inputs and calculates interest rate 
 */

public class InterestClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //scanner
		System.out.println("Enter a principal or starting amount.");
		int princ = scan.nextInt();
		System.out.println("Enter the percentage rate:");
		double rate = scan.nextDouble();
		System.out.println("Enter a number of years.");
		int time = scan.nextInt();
		
		//math number magic happens here
		double interest = princ * rate * time;
		
		System.out.println("You will accrue " + interest);
	}

}
