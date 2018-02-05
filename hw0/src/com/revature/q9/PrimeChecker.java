package com.revature.q9;

import java.util.List;
import java.util.Scanner;

public class PrimeChecker {

	public PrimeChecker() {
		super();
	}

	public List<Integer> acquireNumRange(List<Integer> nums) {
		Scanner scan = new Scanner(System.in);
		int first, last;
		System.out.println("Range of numbers:");
		System.out.println("From?");
		first = Integer.parseInt(scan.nextLine());
		System.out.println("To?");
		last = Integer.parseInt(scan.nextLine());

		for (int i = first; i <= last; i++)
			nums.add(i);

		return nums;
	}

	public boolean isPrime(int n, boolean revLogic) {
		if (revLogic) {
			for (int i = 2; i <= n / 2; i++) {
				if (n % i == 0)
					return true;
			}
			return false;
		}
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public void printPrimes(List<Integer> nums, boolean revLogic) {
		for (Integer i : nums) {
			if (isPrime(i, revLogic))
				System.out.println(i);
		}
	}
}
