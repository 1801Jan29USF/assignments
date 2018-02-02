package com.revature.HW1.Q15;



public class TestClass {
	public static void main(String[] args) {
		int a = 20;
		int b = 10;
		Interfaces myInterface = new Interfaces();
		myInterface.add(a, b);  // 20 plus 10 
		myInterface.subract(a, b);  //20 minus 10
		myInterface.divide(a, b); //20 divided by 10
		myInterface.multiply(a, b); //20 multiplied by 10
		
	}

}
