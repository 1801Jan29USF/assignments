package com.revature.question9;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		boolean isPrime = true;

		for (int i = 1; i < 101; i++) {
			numbers.add(i);
		}

		for(Integer num : numbers) {
			isPrime = true;
			if (num == 1) {
				System.out.println("1 is not a prime number");
			} else {
				for (int i = 2; i <= num/2; i++) {
					if (num % i == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime == true) {
					System.out.println(num);
				}
			}
		}
	}
}
