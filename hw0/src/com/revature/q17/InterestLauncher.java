package com.revature.q17;

import java.util.Scanner;

public class InterestLauncher {
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		InterestCalc ic = new InterestCalc();
		
		System.out.println(("What is the principal?: "));
		float principal = Float.parseFloat(scan.nextLine());
		System.out.println(("What is the rate?: "));
		float rate = Float.parseFloat(scan.nextLine());
		System.out.println(("How many years?: "));
		System.out.println("Interest = " + ic.calcInterest(principal, rate, Integer.parseInt(scan.nextLine())));
		scan.close();
	}
}
