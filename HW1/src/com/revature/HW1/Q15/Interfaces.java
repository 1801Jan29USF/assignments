package com.revature.HW1.Q15;


/**
 * @author Brandon
 * Implementation class for the interface methods. Contains the logic in a print line outputting the result.
 */
public class Interfaces implements MyInterface {

	@Override
	public void add(int a, int b) {
		System.out.println("The sum is " + (a + b));
	}

	@Override
	public void subract(int a, int b) {
		System.out.println("The difference is " + (a - b));
		
	}

	@Override
	public void divide(int a, int b) {
		System.out.println("The quotient is " + (a / b));
		
	}

	@Override
	public void multiply(int a, int b) {
		System.out.println("The product is " + (a * b));
		
	}

	

}
