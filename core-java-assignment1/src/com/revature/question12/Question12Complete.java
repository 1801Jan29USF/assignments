package com.revature.question12;

public class Question12Complete {
	public static void main(String[] args) {
		// Creating my array
		int[] arr = new int[101];
		
		// Filling my array with the index number
		for (int i = 1; i < 101; ++i) {
				arr[i] = i;
		}
		
		// Printing out only the even numbers from the array with 
		// an enhanced for loop
		for (int i: arr) {
			if(arr[i] % 2 == 0) {
				System.out.println(arr[i]);
			}
		}
	}
}