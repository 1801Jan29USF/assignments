package com.revature.q15;

public class FourFunctionCalculator implements FourFunctionMath {

	@Override
	public int addition(int i, int j) {
		return i + j;
	}

	@Override
	public int subtraction(int i, int j) {
		return i - j;
	}

	@Override
	public int multiplication(int i, int j) {
		return i * j;
	}

	@Override
	public float division(int i, int j) {
		return i / j;
	}

}
