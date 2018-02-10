package com.revature.q6;

public class EvenChecker {

	public EvenChecker() {
		super();
	}

	public boolean isEven(int num) {
		/*if(Integer.numberOfLeadingZeros(num) == 0) {
			return true
		}*/
		if((num & 1) == 0) {
			return true;
		}
		return false;
	}
	
}
