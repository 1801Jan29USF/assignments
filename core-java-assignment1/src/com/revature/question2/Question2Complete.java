package com.revature.question2;

public class Question2Complete {
	public static void main(String[] args) {
		System.out.println("Here are the first 25 Fibonacci numbers: ");
		
		// Simple for loop to print out the first 25
		// Fibonacci numbers
		for(int i = 0; i < 25; i++) {
			System.out.print(fibonacciGenerator(i) + " ");
		}
	}
	
	// A small method using recursion to find the fibonacci number
	// of the given number.
	static int fibonacciGenerator(int num) {
		if(num <= 1) {
			return num;
		}
		return fibonacciGenerator(num - 1) + fibonacciGenerator(num - 2);
	}
}
