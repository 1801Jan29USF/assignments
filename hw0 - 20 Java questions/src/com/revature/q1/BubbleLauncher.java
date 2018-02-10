package com.revature.q1;

public class BubbleLauncher {
	
	public static void main(String[] args) {
		int[] intArray = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		
		BubbleSorter bubSrt = new BubbleSorter(intArray);
		System.out.println("Unsorted array:");
		bubSrt.printArray();
		
		System.out.println("Sorted array:");
		bubSrt.sort();
		bubSrt.printArray();
	}

}