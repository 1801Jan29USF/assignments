package com.revature.question3;

public class Question3Complete {
	public static void main(String[] args) {
		
		// Inputting the string to be reversed
		String s1 = "THIS IS MY REAL VOICE";
		
		// Because I reverse my string by converting it to a char array
		// and then printing it out in a for loop, I print out the 
		// String after the reversal: line in the previous sysout
		// so it is not printed out repeatedly.
		System.out.print("String before the reversal: " + s1 + "\nString after the reversal: ");
		
		
		// I convert the string to a chararray so I am able to reverse the character
		// by iterating through a loop.
		char[] arr = s1.toCharArray();
		
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}
}
