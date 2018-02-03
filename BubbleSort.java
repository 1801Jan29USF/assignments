package com.revature.bubble;

public class BubbleSort {
//question 1	
	static void bubbleSort(int arr[]) {
		
		int l = arr.length;
		int t = 0;
		for (int i = 0; i < l; i++) {
			for (int j = 1; j < l-i; j++) {
				if (arr[j-1]>arr[j]) {
					// swapp the numbers
					 t = arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=t;
					
					
				}
				
			}
			
		}
	}
	
	public static void main(String[] arg) {
		
		int [] arr = {10,3,5,6,3,2,3,7,9,8,4};
		
		for (int i = 0; i < arr.length; i++) {
			 
			System.out.print(arr[i]);
			
			
		}
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			
		}
		
		
		
	}

}
