package com.revature.q9;

import java.util.ArrayList;
import java.util.List;

public class PrimeLauncher {
	
	public static void main(String[] args) {

		List<Integer> nums = new ArrayList<>();
		PrimeChecker pc = new PrimeChecker();
		
		nums = pc.acquireNumRange(nums);
		System.out.println("Prime nums from what you selected");
		pc.printPrimes(nums, false);
		
	}

}
