package com.revature.Q09;

import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) {
		ArrayList<Double> arr = new ArrayList<Double>();

		for (double i = 1; i <= 100; i++) {
			arr.add(i);
			// Take numbers who are perfect squares
			if (Math.sqrt(i) - Math.floor(Math.sqrt(i)) == 0) {
				arr.remove(i);
			}
			// Makes sure to include 2, 3, 5, 7 and not 6
			else if (i >= 2 && i <= 7 & i != 6) {
				continue;
			}
			/*
			 * Remove all numbers who are divisible by the first 4 prime numbers. 4 and 6 do
			 * not need to be checked. The other option would be to have if else statements
			 * for 2, 3, 5, 7
			 */
			for (double j = 2; j <= 7; j++) {
				if (i % j == 0) {
					arr.remove(i);
				}
			}
		}
		System.out.println(arr);
		System.out.println(arr.size());
	}
}
