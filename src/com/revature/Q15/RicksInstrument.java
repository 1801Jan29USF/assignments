package com.revature.Q15;

/*
 * Implements the Calculator interface
 */
public class RicksInstrument implements Calculator {

	@Override
	public double addition(double one, double two) {
		double sum = one + two;
		return sum;
	}

	@Override
	public double substraction(double one, double two) {
		double difference = one - two;
		return difference;
	}

	@Override
	public double multiplication(double one, double two) {
		double product = one * two;
		return product;
	}

	@Override
	public double division(double one, double two) {
		double quotient = one / two;
		return quotient;
	}

}
