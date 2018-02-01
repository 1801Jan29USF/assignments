package com.revature.question9;

import java.util.ArrayList;

public class Question9Complete {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		// Populate the array with numbers from 1 to 100.
		for(int i = 1; i < 101; ++i) {
			arr.add(i);
		}
		
		System.out.println("Every prime number from 1 to 100 is: ");
		// Using the checkPrime method, checks if every number from the
		// array is prime, and if that number is, prints it out.
		for(int i = 1; i < 100; ++i) {
			if(checkPrime(arr.get(i)) == true) {
				System.out.print(arr.get(i) + " ");
			}
		}
	}
	
	// The same prime number check method I use from question 19.
	static boolean checkPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
	        if (num % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
}