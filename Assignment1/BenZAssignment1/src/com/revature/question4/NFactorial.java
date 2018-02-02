package com.revature.question4;

public class NFactorial {
	public static void main(String[] args) {
		// Could implement user input n
		int n = 5;
		int sum = 1; 
		
		for(int i = 1; i <= n; i++) {
			sum *= i;
		}
		System.out.println(sum);
	}

}