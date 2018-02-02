package com.revature.question2;

public class FiboNumbers {
	// Using Recursion
/*  	public static void main(String[] args) {
		for(int i = 0; i < 25; i++) {
			System.out.println(f(i));
		}
	}
	private static int f (int i) {
		if(i == 0)
			return 0;
		else if(i == 1)
			return 1;
		return f(i-1) + f(i-2);
	}
*/
	
	//Without Recursion
	public static void main(String[] args) {
		int sum, prev = 1, prevPrev = 0;
		System.out.println(0 + "\n" + 1);
		for(int i = 0; i < 23; i++) {
			sum = prev + prevPrev;
			prevPrev = prev;
			prev = sum;
			System.out.println(sum);
		}
	}
}
