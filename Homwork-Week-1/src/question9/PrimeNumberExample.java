package question9;

import java.util.ArrayList;

public class PrimeNumberExample {

	// logic for prime number
	static boolean isPrimeNumber(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();

		/// storing from 1 to 100
		for (int i = 1; i <= 100; ++i) {
			ar.add(i);
		}

		System.out.println("Prime numbers between 1 and 100: ");

		// isPrimeNumber method is used to checks if every number from the
		// array is prime to be printed
		for (int i = 1; i < 100; ++i) {
			if (isPrimeNumber(ar.get(i)) == true) {
				System.out.print(ar.get(i) + " ");
			}
		}
	}

}
