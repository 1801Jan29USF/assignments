package com.revature.Q02;

public class Fibonacci {
	public static void main(String[] args) {

		Fibonacci f = new Fibonacci();

		// Print Fibonacci sequence up to 25
		for (int i = 0; i < 25; i++) {
			System.out.println(f.fibSeq(i));
		}

	}

	/*
	 * Recursive method for Fibonacci sequence
	 */
	int fibSeq(int i) {

		// First base case 0 is just 0
		if (i == 0) {
			return 0;
			// Same for one
		} else if (i == 1) {
			return 1;
		} else {
			// Takes care of the rest... (2-1)+(2-2)=1 and so on
			return fibSeq(i - 1) + fibSeq(i - 2);

		}

	}

}
