package com.revature.question15;

public class Question15Implementer implements Question15Interface{
	
	// My implemented interface class. Implements all of the required methods from the interface.
	
	@Override
	public int addition(int num1, int num2) {
		int temp = num1 + num2;
		return temp;
	}

	@Override
	public int subtraction(int num1, int num2) {
		int temp = num1 - num2;
		return temp;
	}

	@Override
	public double multiplication(double num1, double num2) {
		double temp = num1 * num2;
		return temp;
	}

	@Override
	public double division(double num1, double num2) {
		return 0;
	}
}