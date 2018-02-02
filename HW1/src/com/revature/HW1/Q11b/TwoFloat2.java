package com.revature.HW1.Q11b;

import com.revature.HW1.Q11a.TwoFloat;

public class TwoFloat2 {
	public static void main(String[] args) {

		float newf1 = TwoFloat.getF1(); // Gets the floats from TwoFloat in package Q11a
		float newf2 = TwoFloat.getF2();

		System.out.println("local float 1: " + newf1);
		System.out.println("local float 2: " + newf2);

		TwoFloat.setF1((float) 10.5); // Setting the floats in the other package to new values.
		TwoFloat.setF1((float) 45.7);

		System.out.println("New float 1: " + TwoFloat.getF1());
		System.out.println("New float 2: " + TwoFloat.getF2());

	}

}
