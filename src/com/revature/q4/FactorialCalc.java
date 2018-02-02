package com.revature.q4;

public class FactorialCalc {

	public FactorialCalc() {
		super();
	}
	
	public int nFact(int n) {
		int fact = 1;
		for(int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

}
