package com.revature.q2;

public class Fibonacci {
	
public static void main(String[] args) {
	int num0 = 0;
	int num1 = 0; 
	int num2 = 1; 
	System.out.print(num0 + ",");
	
	for (int i = 0; i < 24;++i) {
		int num3= num1 + num2; 
		System.out.print(num3 +",");
		num1 = num2;
		num2 = num3; 
	}
	
	
}
}
