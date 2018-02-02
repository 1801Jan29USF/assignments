package Question2;

import java.util.Arrays;

public class Q2Launcher {

	/* Prints the first "num" fibonacci numbers. Assumes an input of at least 2. */
	public static int[] fib(int num) {
		// Creates an empty array to fill with fibonacci numbers
		int[] fNumbers = new int[num];
		// The first Fibonacci number is 0; the second is 1.
		fNumbers[0] = 0;
		fNumbers[1] = 1;
		/*
		 * Extrapolates each subsequent Fibonacci number by adding its two immediate
		 * predecessors
		 */
		for (int i = 2; i < num; i++) {
			fNumbers[i] = fNumbers[i - 1] + fNumbers[i - 2];
		}
		return fNumbers;
	}

	public static void main(String[] args) {
		System.out.print(Arrays.toString(fib(25)));
	}

}
