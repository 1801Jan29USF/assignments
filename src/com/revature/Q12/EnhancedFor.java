package com.revature.Q12;

/*
 * Not sure why I had to make the array length 101. Won't work with 100
 */
public class EnhancedFor {

	/*
	 * Tried to make it work with size 100 but not sure why it doesn't work
	 * 
	 */
	public static void main(String[] args) {
		int[] array = new int[101];
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				array[i] = 1;
				continue;
			}
			array[i] = i;
		}
		// Check for evens and prints
		for (int i : array) {
			if (array[i] % 2 == 0)
				System.out.println(array[i]);
		}
	}

}
