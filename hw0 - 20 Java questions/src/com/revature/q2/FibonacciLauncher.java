package com.revature.q2;

import java.util.Scanner;

public class FibonacciLauncher {
	
	public static void main(String[] args) {
		FibonacciGenerator fibGen = new FibonacciGenerator();
		Scanner scan = new Scanner(System.in);
		System.out.println("How many fibonacci numbers would you like?");
		fibGen.fibDisplay(Integer.parseInt(scan.nextLine()));
	}

}