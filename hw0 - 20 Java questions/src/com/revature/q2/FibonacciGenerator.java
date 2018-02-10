package com.revature.q2;

public class FibonacciGenerator {
	
	// Blank constructor when no parameters are given when creating an instance of this class
	public FibonacciGenerator() {
		super();
	}
	
	// get a fib #
	public int fibGet(int num) {
			if(num < 2) {
				return num;
			}
			else return fibGet(num-1) + fibGet(num-2);
	}
	
	public void fibDisplay(int num) {
		for(int i = 0; i < num; i++) {
			System.out.println(fibGet(i));
		}
	}

}