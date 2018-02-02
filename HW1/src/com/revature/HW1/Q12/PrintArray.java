package com.revature.HW1.Q12;

public class PrintArray {
	public static void main(String[] args) {
		int[] array = new int[100]; // instantiates an array

		for (int i = 1; i <= 100; i++) { // starts i at 1 to avoid placing zero in the array
			array[i - 1] = i; // put places at i-1 index
		}
		for (int x : array) { // for each integer in the array divisible by 2 with no remainders
			if (x % 2 == 0) {
				System.out.println(x); // print
			}

		}
	}

}
