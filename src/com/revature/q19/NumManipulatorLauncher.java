package com.revature.q19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.q12.EvensFromArray;
import com.revature.q9.PrimeChecker;

public class NumManipulatorLauncher {

	public static void main(String[] args) {
		
		PrimeChecker pc = new PrimeChecker();
		EvensFromArray efa = new EvensFromArray();
		List<Integer> nums = new ArrayList<Integer>();
		Scanner scan  = new Scanner(System.in);
		String input = "";
		
		nums = pc.acquireNumRange(nums);
		
		System.out.println("Your range:");
		System.out.println(nums);
		System.out.println("Sum of evens from that range:");
		System.out.println("1 to use even numbers");
		System.out.println("2 to use odd numbers");
		boolean revLogic = false;
		input = scan.nextLine();
		if (input.equals("2")) {
			revLogic = true;
		}
		System.out.println("Sum of numbers we used = " + efa.sum(nums, !revLogic));
		System.out.println("Your range without any prime numbers: ");
		pc.printPrimes(nums, true);
	}
	
}
