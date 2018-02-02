package com.revature.HQ15;

public class Execution extends Operations {

	
	public static void main(String[] args) {
		int b = 10;
		int c = 5;
		
		Operations o = new Operations();
		
		System.out.println(o.addition(b,c));
		System.out.println(o.subtraction(b, c));
		System.out.println(o.multiplication(b, c));
		System.out.println(o.division(b, c));
	}

}
