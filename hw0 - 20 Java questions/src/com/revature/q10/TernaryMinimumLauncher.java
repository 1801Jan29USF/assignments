package com.revature.q10;

import java.util.Scanner;

public class TernaryMinimumLauncher {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TernaryMinimum tm = new TernaryMinimum();
		System.out.println("Enter first #:");
		int first = scan.nextInt();
		System.out.println("Enter 2nd #:");
		int second = scan.nextInt();
		System.out.println(tm.getMin(first, second));
	}

}
