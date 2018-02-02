package com.revature.HW1.Q2;

import java.util.Arrays;

public class Fibonacci {
	public static void main(String[] args) {

		int[] fibarray = new int[25]; // declared array

		fibarray[0] = 0; // first two indexes set to 0 and 1
		fibarray[1] = 1;

		for (int i = 0; i < fibarray.length - 2; i++) { // only goes to length - 2, as the operation in the loop uses
														// i+2 as to never exceed bounds
			fibarray[i + 2] = fibarray[i] + fibarray[i + 1]; // every spot in the array is the sum of the two preceding
																// numbers
		}
		System.out.println(Arrays.toString(fibarray));
	}

}
