package com.revature.question19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListManip {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		List<Integer> toRemove = new ArrayList<>();
		
		int sum = 0;
		boolean isPrime = true;
		
		for(int i = 1; i < 11; i++) {
			numbers.add(i);
		}
		printList(numbers);
		
		for(Integer n: numbers) {
			if(n % 2 == 0)
				sum += n;
		}
		System.out.println("Sum of evens: " + sum);
		
		for(Integer n: numbers) {
			if(n % 2 != 0)
				sum += n;
		}
		System.out.println("Sum of odds: " + sum);
		
		for(Integer num : numbers) {
			isPrime = true;
			if (num == 1) {
				// do nothing
			} else {
				for (int i = 2; i <= num/2; i++) {
					if (num % i == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime == true) {
					toRemove.add(num);
				}
			} 
		}
		numbers.removeAll(toRemove);
		System.out.println("Without Primes: " + numbers);
		
	}
	
	static void printList(List<Integer> num) {
		for(Integer n : num) {
			System.out.println(n);
		}
	}
}
