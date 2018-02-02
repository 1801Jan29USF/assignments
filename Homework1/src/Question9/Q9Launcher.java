package Question9;

import java.util.ArrayList;

public class Q9Launcher {

	/**
	 * Class determines whether or not a given integer is prime
	 * 
	 * @param testMe
	 * @return
	 */
	public static boolean isPrime(int testMe) {
		// No number less than 2 is prime
		if (testMe < 2) {
			return false;
			// 2 is always prime
		} else if (testMe == 2) {
			return true;
			// Even numbers are never prime
		} else if (testMe % 2 == 0) {
			return false;
		}
		/*
		 * Loop tests if given number is divisible by any number between 3 and its own
		 * square root. If it is, it is not prime, so the function returns false.
		 */
		for (int i = 3; i * i <= testMe; i += 2) {
			if (testMe % i == 0) {
				return false;
			}
		}
		// If the program has not already returned false, the number is prime
		return true;
	}

	public static ArrayList<Integer> primesList(ArrayList<Integer> input) {
		// Creates a new ArrayList to hold the prime numbers
		ArrayList<Integer> primes = new ArrayList<Integer>();
		// Check whether each number in array is prime. Loads all primes into primes
		// arraylist
		for (int i = 0; i < input.size(); i++) {
			if (isPrime(input.get(i))) {
				primes.add(input.get(i));
			}
		}
		// Returns array containing only the primes
		return primes;

	}

	public static void main(String[] args) {
		// Initializes an ArrayList with the values 1 to 100
		ArrayList<Integer> oneToHundred = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			oneToHundred.add(i);
		}
		// Creates new arraylist containing only the prime numbers from 1 to 100
		ArrayList<Integer> allPrimes = primesList(oneToHundred);
		// Prints out all numbers within that array
		for (int j = 0; j < allPrimes.size(); j++) {
			System.out.println(allPrimes.get(j));
		}

	}

}
