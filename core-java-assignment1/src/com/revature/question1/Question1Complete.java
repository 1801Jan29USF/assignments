package com.revature.question1;

public class Question1Complete {
	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		// Sysouts to print the array before and after the bubble sort.
		System.out.println("The array before the bubble sort: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		
		bubbleSort(arr);
		
		System.out.println("\nThe array after the bubble sort: ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	// My method to bubble sort the array. Checks the closest two elements
	// and if the first one is bigger then the second one, swaps the elements.
	static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
            	if (arr[j] > arr[j+1]) {
            	   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                    
                }
            }
        }
    }
}