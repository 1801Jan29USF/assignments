package com.revature.HW1.Q9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimeInArray {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(); // creates arraylist
		List<Integer> list2 = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			list.add(i+1); // adds 1-100 into the list
		}
		System.out.println(list); // displays the list
		
		
		Iterator<Integer> iterator = list.iterator(); //Iterator to go through the list
		  // Without an iterator, was getting ConcurrentModificationException
		while(iterator.hasNext()) {
			Integer x = iterator.next();

			if(checkPrime(x) == true)     //If the element returns true from a "checkPrime" method
				list2.add(x);		  //remove the prime number from our list.
		}

	
		System.out.println("Our list of prime numbers: ");
		System.out.println(list2); //Prints our list of only prime numbers

	}


	private static boolean checkPrime(int number) {  //Method to check for prime numbers
		if (number <= 1){
			return false;
		}
		if( number <= 2 || number == 3)    //If 2 or 3, always true
			return true;


		for(int i = 2; i < Math.sqrt(number)+1; i++) {  //Prime number theorem says for a number of X value, 1/Log(X) prime numbers are possible
			if ( number % i == 0) 	//If it perfectly divides by initially two,  up to Sqrt(number)+1, then it is not prime.
				return false;
		}
		return true;  //if not perfectly divisible by any iterated number above, returns true
	}
		
		
	}




