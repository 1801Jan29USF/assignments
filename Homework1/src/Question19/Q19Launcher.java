package Question19;

import java.util.ArrayList;

public class Q19Launcher {

	/**
	 * Method for determining if a number is prime. Copies from Question 9.
	 * 
	 * @param testMe
	 * @return
	 */
	public static boolean isPrime(int testMe) {
		if (testMe < 2) {
			return false;
		} else if (testMe == 2) {
			return true;
		} else if (testMe % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= testMe; i += 2) {
			if (testMe % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// Creates aggregate variable for later use
		int agg = 0;
		// Creates temporary value for use in loops
		int temp = 0;
		// Creates and initializes an ArrayList with the values 1 through 10
		ArrayList<Integer> toTen = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			toTen.add(i);
		}
		// Prints the array containing 1 through 10
		System.out.println(toTen.toString());
		// Adds the even numbers within the toTen array, stores the sum in agg, and
		// prints it
		for (int i = 1; i < 10; i += 2) {
			agg += toTen.get(i);
		}
		System.out.println(agg);
		agg = 0;
		// Adds the odd numbers within the toTen array, stores the sum in agg, and
		// prints it
		for (int i = 0; i < 10; i += 2) {
			agg += toTen.get(i);
		}
		System.out.println(agg);
		agg = 0;

		// Removes all non-prime numbers from toTen and prints the result
		while (agg < toTen.size()) {
			agg = toTen.get(temp);
			if (isPrime(agg)) {
				toTen.remove(temp);
			} else {
				temp++;
			}
		}
		System.out.println(toTen.toString());
	}

}
