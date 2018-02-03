package com.revature.q15;
public class Test {
	public static void main(String[] args) {
		
		int num1 = 40; 
		int num2 = 20;
		
		Implementation imp = new Implementation();
		
		int a1 = imp.add(num1, num2);
		int s1 = imp.sub(num1, num2);
		int m1 = imp.mult(num1, num2);
		double d1 = imp.div(num1, num2);
		
	
		System.out.println("Addition = " + a1);
		System.out.println("Subtraction = " + s1);
		System.out.println("Multiplication = " + m1);
		System.out.println("Division = " + d1);
	}

}
