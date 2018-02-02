package com.revature.HW1.Q11a;

public class TwoFloat {

	public static float f1 = 5.5f; // static so I didn't have to instantiate a class, but floats are private
	public static float f2 = 10.2f;

	public static float getF1() { // getters and setters
		return f1;
	}

	public static void setF1(float input) {
		f1 = input;
	}

	public static float getF2() {
		return f2;
	}

	public static void setF2(float input) {
		f2 = input;
	}

}
