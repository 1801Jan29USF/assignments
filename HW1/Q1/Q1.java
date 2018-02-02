package com.revature.Q1;

public class Q1 {
	public static void main(String[] args) {
		//populate array
		int[] arr = new int[] { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int temp = 0;
		//loop through entire array
		for(int i = 0; i < arr.length; i++) {
			//begin second loop at successive element and push
			//greatest value to end of array each iteration (preserving order)
			for (int j = 1; j < (arr.length - i); j++) {
				//check if successive element is greater
				if (arr[j - 1] > arr[j]) {
					// swap the elements using temp 
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
