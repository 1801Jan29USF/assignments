package com.revature.q1;

public class BubbleSort {

	public static void main(String[] args) {
		int [] arr = {1,0,5,6,3,2,3,7,9,8,4}; //initialized array 
		
		bubbleSort(arr); //uses the bubble sort function
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ","); 
		} 
	}
	

	public static void bubbleSort(int[] arr) {
		
		int l = arr.length;  
		
		for (int i = 0; i <l ; i++) {
			
			for(int j = 1; j< l; j++){
				
			if (arr[j-1] > arr[j]) { //checks if the preceder is greater
				
				int temp = arr [j-1]; //if preceder is greater, it swaps with the successor 
				arr[j-1] = arr[j];
				arr[j] = temp; //
			}
		}
	}
}		
	


}
