package com.revature.Q2;

public class Q2 {

	static void fib(int n) {
		int a = 0;
		int b = 1;
		int i = 0;
		System.out.print(0 + " ");
		// reduce n because 0 was already output
		//leaving n - 1 more values
		n = n - 1;
		//each number in series is sum of two previous numbers
		for (i = 1; i <= n; i++) {
			System.out.print(b + " ");
			int next = a + b;
			a = b;
			b = next;
		}
	}

	public static void main(String[] args) {
		fib(25);
	}
}