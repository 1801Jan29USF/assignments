package com.revature.HQ12;

public class Evens {

	public static void main(String[] args) {
		int[] numbers = new int[100];
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i+1;
		}

		
		for(int j : numbers) {
			if(j%2 == 0) {
				
			System.out.println(j);
			}
		}
	}

}
