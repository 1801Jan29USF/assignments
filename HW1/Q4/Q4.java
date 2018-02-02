package com.revature.Q4;

public class Q4 {

	static void fac(int N) {
		int i = 0;
		int factorial = 1;
	
		if (N == 0) {
			System.out.println(0);
		}
		
		for (i = N; i > 0; i--) {
			factorial = factorial * i;
		}
		
		System.out.println(factorial);
	}

	public static void main(String[] args) {
		int N = 7;
		fac(N);
	}
}
