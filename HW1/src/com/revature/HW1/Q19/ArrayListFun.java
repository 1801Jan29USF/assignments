package com.revature.HW1.Q19;

import java.util.*;

public class ArrayListFun {
	public static void main(String[] args) {
		Integer sum = 0;
		Integer sum2 = 0;
		List<Integer> list = new ArrayList<>(); // creates arraylist

		for (int i = 1; i <= 10; i++) {
			list.add(i); // adds 1-10 into the list
		}
		System.out.println(list); // displays the list

		for (Integer x : list) { //For every integer in the list, if it's modulo operation is zero and it's an even number, then add it to the even sums
			if (x % 2 == 0) {
				sum += x;
			}
		}
		System.out.println("The sum of the even elements is: " + sum);

		for (Integer x : list) { //Find the odds elements using modulo operation, add them to the sum of odd numbers.
			if (x % 2 != 0) {
				sum2 += x;
			}
		}
		System.out.println("The sum of the odd elements is: " + sum2);
		
		
		
		/*for(Integer x : list) {
			if(checkPrime(x) == true) // original attempt at getting this to work
				list.remove(x);
		}*/
		
		
		Iterator<Integer> iterator = list.iterator(); //Iterator to go through the list
													  // Without an iterator, was getting ConcurrentModificationException
		while(iterator.hasNext()) {
			Integer x = iterator.next();
			
			if(checkPrime(x) == true)     //If the element returns true from a "checkPrime" method
				iterator.remove();		  //remove the prime number from our list.
		}
		
		System.out.println(list);  //print the list
			
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
