package com.revature.Q06;

public class Evens {

	public static void main(String[] args) {
		Evens eve = new Evens();
		System.out.println(eve.isEven(215));
	}

	boolean isEven(int num) {
		double n = (double) num;
		double x = (n / 2) - Math.floor(n / 2);

		if (x == 0.0) {
			System.out.println(x);
			return true;
		} else {
			System.out.println(x);
			return false;
		}
	}
}
