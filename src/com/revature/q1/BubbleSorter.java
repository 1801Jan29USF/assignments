package com.revature.q1;

public class BubbleSorter {
	
	private int[] intArray;
	private int len = 0;
	
	public BubbleSorter() {
		super();
	}
	
	public BubbleSorter(int[] iAr) {
		this();
		intArray = iAr;
		len = intArray.length;
	}
	
	// Print out intArray in it's current order
	public void printArray() {
		for (int i = 0; i < len; i++) {
			System.out.print(intArray[i] + " ");
		}
		System.out.println();
	}
	
	// Perform a bubble sort on intArray
	public void sort() {
		boolean swapped = true;
		do {
			int temp;
			swapped = false;
			for (int i = 1; i < len; i++) {
				if (intArray[i-1] > intArray[i]) {
					temp = intArray[i];
					intArray[i] = intArray[i-1];
					intArray[i-1] = temp;
					swapped = true;
				}
			}
		} while(swapped == true);
	}

	// Setters and getters
	
	public int[] getIntArray() {
		return intArray;
	}

	public void setIntArray(int[] intArray) {
		this.intArray = intArray;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}
	

}