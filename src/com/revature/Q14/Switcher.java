package com.revature.Q14;

import java.util.Date;

/*
 * Demonstrates a switch statement with 3 conditional cases
 */
public class Switcher {
	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {
			switch (i) {
			// Square root of a random number
			case 1:
				int number = (int) (Math.random() * 99) + 1;
				System.out.println("Square root: " + (int) Math.sqrt(number));
				break;
			// Today's date
			case 2:
				Date date = new Date();
				System.out.println(date);
				break;
			// Split string
			case 3:
				String java = "I am learning core java";
				String[] arr = java.split(" ");
				for (int k = 0; k < arr.length; k++) {
					System.out.println(arr[k]);
				}
				break;

			default:
				break;
			}
		}

	}

}
