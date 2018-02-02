package com.revature.Q10;

public class Q10 {

	public static int min(int a, int b) {
		return (a < b) ? a : b;
	}

	public static void main(String[] args) {
		int a = 2000;
		int b = 6000;
		System.out.println(min(a, b));
	}
}
