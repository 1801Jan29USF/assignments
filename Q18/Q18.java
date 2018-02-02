package com.revature.Q18;

public class Q18 extends Superclass {
	
	Boolean checkUpper(String str) {
		return !str.equals(str.toLowerCase());
	}
	
	String convertToUpper(String str) {
		return str.toUpperCase();
	}
	
	void convertToInt(String str) {
		 System.out.println(Integer.parseInt(str) + 10);
	}
}

