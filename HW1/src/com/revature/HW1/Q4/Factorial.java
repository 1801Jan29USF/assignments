package com.revature.HW1.Q4;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an integer N to compute its factorial");

		int n = scan.nextInt();
		System.out.println(n);
		int start = 1; // starting point

		for (int i = 1; i <= n; i++) {
			start = start * i; // incrementing from one, multiplying by the next highest number until reaching
								// the given N
		}
		System.out.println(start);
	}

}
