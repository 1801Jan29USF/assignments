package com.revature.q4;

import java.util.Scanner;

public class FactorialLauncher {
	
	public static void main(String[] args) {
		FactorialCalc fc = new FactorialCalc();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n for !n: ");
		System.out.println(fc.nFact(Integer.parseInt(scan.nextLine())));
	}

}
