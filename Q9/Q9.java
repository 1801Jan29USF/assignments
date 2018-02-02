package com.revature.Q9;

import java.util.ArrayList;

public class Q9 {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(100); 
		Boolean isPrime = true;
		numbers.add(1);

		for (int i = 2; i <= 100; i++) {
			numbers.add(i);
			// check if prime while populating
			for (int j = 2; j < i; j++) {
				// number isn't prime
				if (i % j == 0) {
					isPrime = false;
					//stop checking preceding numbers
					break;
				}
			}
			// print prime number
			if (isPrime == true) {
				System.out.println(i);
			} else {
				// reset isPrime
				isPrime = true;
			}
		}
	}
}
