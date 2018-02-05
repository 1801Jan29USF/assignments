package com.revature.q6;

import java.util.Scanner;

public class EvenCheckLauncher {
	
	public static void main(String[] args) {
		EvenChecker ec = new EvenChecker();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number and find out if it is even:");
		System.out.println(ec.isEven(scan.nextInt()));
	}

}
