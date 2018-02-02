package com.revature.HW1.Q1;

import java.util.Arrays;

public class BubblesSort {

	public static void main(String[] args) {

		int givenarray[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int x = givenarray.length; // using a length variable to cut down on confusion
		int tempvar;
		System.out.println(givenarray[2]);

		for (int i = 0; i < x - 1; i++) { // outer for loop reiterating the process once digits have shifted one space

			for (int j = 1; j < x - i; j++) { // inner for loop, starting j = 1 to compare it to an element behind it
				if (givenarray[j] < givenarray[j - 1]) { // if element j is less than the one behind it
					tempvar = givenarray[j - 1]; // use a temporary variable to switch the positions
					givenarray[j - 1] = givenarray[j];
					givenarray[j] = tempvar;
				}

			}
		}

		System.out.println(Arrays.toString(givenarray)); // prints the array as a string for simplicity to check
															// correctness

	}

}
