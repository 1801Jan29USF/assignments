package Question17;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Q17Launcher {

	/*
	 * Reads principal, rate and time from command line prompts and returns the
	 * interest.
	 */
	public static void main(String[] args) {
		// Creates new scanner to read user input
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		// Takes principal from the command line
		System.out.println("Please enter your principal:");
		Double principal = scanner.nextDouble();
		// Takes rate from the command line
		System.out.println("Please enter your rate:");
		Double rate = scanner.nextDouble();
		// Takes Time from the command line
		System.out.println("Please enter your time:");
		Double time = scanner.nextDouble();
		// Prints out the interest, the product of principal, rate and time
		System.out.println("Your interest is " + principal * rate * time);
		// Closes the scanner
		scanner.close();

	}

}
