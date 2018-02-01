package com.revature.question19;

import java.util.ArrayList;
import java.util.List;

public class Question19Complete {
	public static void main(String[] args) {
		List<Integer> arr1 = new ArrayList<Integer>();
		
		// Two ints to add up the even and odd numbers in my arraylist
		int sumEven = 0;
		int sumOdd = 0;

		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
		arr1.add(4);
		arr1.add(5);
		arr1.add(6);
		arr1.add(7);
		arr1.add(8);
		arr1.add(9);
		arr1.add(10);
		
		System.out.println("The numbers contained in the arraylist are: " + arr1 + " ");

		// For loop that checks if a number is even, then adds it to my
		// sumEven variable.
		for(int i = 0; i < arr1.size(); i++) {
			if(arr1.get(i) % 2 == 0) {
				sumEven = sumEven + arr1.get(i);
			}
		}
		
		// For loop that checks if a number is odd, then adds it to my
		// sumOdd variable.
		System.out.println("\nThe even numbers contained in the arraylist add up to: " + sumEven);
		
		for(int i = 0; i < arr1.size(); i++) {
			if(arr1.get(i) % 2 == 1) {
				sumOdd = sumOdd + arr1.get(i);
			}
		}
		
		System.out.println("\nThe odd numbers contained in the arraylist add up to: " + sumOdd);
		
		
		// For loop that checks if a number is prime,
		// and if it is, removes it from the arraylist.
		for(int i = 0; i < arr1.size(); i++) {
	        if (checkPrime(arr1.get(i)) == true) {
	            arr1.remove(i);
	        }
	    }
		
		System.out.println("\nThe numbers contained in the arraylist after removing all prime numbers are: " + arr1 + " ");
	}
	
	// Method to check if a number is prime. Couldn't figure out how to remove two from 
	// my array, not sure if its logic or my arraylist acting weird.
	static boolean checkPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
	        if (num % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
}