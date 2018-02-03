package com.revature.factorial;
//Q4

public class nFactorial {
	public static void main(String[] args) {
		int f = 1;
		
		int num = 5; //factorial
		for(int i = 1; i <= num; i++) {
			f = f*i;
			
		}
		System.out.println("The factorial of " + num + " is "+ f);
		
	}
	

}
