package com.revature.question6;

public class EvenInteger {
	public static void main(String[] args) {
		//prolly should have user input here as well
		System.out.println(checkEven(56));
		System.out.println(checkEven(33));
		System.out.println(checkEven(75));
		System.out.println(checkEven(186));
	}
	// Not sure if this is the intended method but it works
	public static String checkEven(int i) {
		System.out.print(i + " ");
		if((i & 1) == 0)
			return "Even";
		else
			return "Odd";
		
		
		

			
	}
}
