package com.revature.Q04;

public class Factorial {

	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.factorial(5));
	}

	/*
	 * Recursively obtain the factorial of a number
	 */
	int factorial(int n) {
		// Base case 0
		if (n == 0)
			return 1;
		// Base case 1
		else if (n == 1)
			return 1;
		else
			/*
			 * Factorial of any other number is found by multiplying the number by the
			 * factorial of that number minus one
			 */
			return n * factorial(n - 1);
	}

}
