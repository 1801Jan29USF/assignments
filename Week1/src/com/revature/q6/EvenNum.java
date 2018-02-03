package com.revature.q6;

import java.util.Scanner;

public class EvenNum {
public static void main(String[] args) {
	
	Scanner num= new Scanner(System.in);
	
	System.out.println("Enter your number: " );
	
	int num1 = num.nextInt();


	int div = num1 / 2; 
	
	if (div * 2  == num1 ){
		System.out.println("Your number is Even" );
	}
	else 
		System.out.println("Your number is Odd" );
	
}
}
