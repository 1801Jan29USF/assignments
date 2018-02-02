package com.revature.Q19;

import java.util.ArrayList;
import java.util.Arrays;

public class Q19 {
	
	 static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static void addEven(ArrayList<Integer> arr) {
		int sum = 0;
		for (int i: arr) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}
		System.out.println(sum);
	}
	
	static void addOdd(ArrayList<Integer> arr) {
		int sum = 0;
		for (int i: arr) {
			if (i % 2 != 0) {
				sum = sum + i;
			}
		}
		System.out.println(sum);
	}
	
	static void removePrimes(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == 1) {
				continue;
			}
			if (isPrime(arr.get(i))) {
				arr.remove(i);
				i = i - 1;
			}
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		for (int i : numbers) {
			System.out.println(i);
		}
		
		addEven(numbers);
		addOdd(numbers);
		removePrimes(numbers);
		
		for (int i : numbers) {
			System.out.println(i);
		}
	}
}