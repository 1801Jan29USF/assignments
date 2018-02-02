package com.revature.Q01;

public class BubbleSort {

	public static void main(String[] args) {

		int[] myarr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		BubbleSort b = new BubbleSort();
		b.bubbleSort((myarr));
		b.printArray(myarr);
	}

	void bubbleSort(int[] arr) {
		// Iterate through array
		for (int i = 0; i < arr.length; i++) {

			/*
			 * Sort the elements in the array by comparing the current element to the next
			 * and swapping the values accordingly.
			 */
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}

	}

	// Print array
	void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
