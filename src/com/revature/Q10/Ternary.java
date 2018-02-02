package com.revature.Q10;

public class Ternary {
	public static void main(String[] args) {
		Ternary terner = new Ternary();
		int o = 10;
		int t = 200;
		System.out.println(terner.findmin(o, t));
	}

	/*
	 * Return whichever of the numbers is less than the other
	 */
	int findmin(int one, int two) {
		int minimum = (one < two) ? one : two;
		return minimum;
	}
}
