package com.revature.Q15;

public class TestCalculator {
	public static void main(String[] args) {
		RicksInstrument calc = new RicksInstrument();
		double operand1 = 35, operand2 = 10;
		System.out.println("Sum: " + calc.addition(operand1, operand2));
		System.out.println("Difference: " + calc.substraction(operand1, operand2));
		System.out.println("Product: " + calc.multiplication(operand1, operand2));
		System.out.println("Quotient: " + calc.division(operand1, operand2));
	}
}
