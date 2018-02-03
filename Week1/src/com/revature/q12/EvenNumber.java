package com.revature.q12;

public class EvenNumber {
	


	public static void main(String[] args) {
		
		int arr[] = new int[102]; //creating array of 102 

		//giving index from 0 to 101
		for (int i = 0; i< arr.length ; i++)	{ 
			arr[i] =+ i;
			
		}
	//checks if the index is even or by dividing the index number by 2 
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] % 2 == 0 ) //if the remainder is 0, it prints the number as it is even 
				
				System.out.println(arr[i]);
		}
		
		
		
	}

}
