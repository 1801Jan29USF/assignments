package com.revature.HW1.Q6;
import java.util.Scanner;

public class CheckIfEven {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  //scanner to take input
		
		System.out.println("Enter any integer to determine odd or even.");
		int n = scan.nextInt();  //user input
		
		if((n / 2 ) * 2 == n) {  // if the integer quotient of an integer and two can be multiplied by 2 to get the same number, then it is even.
			System.out.println("The number is even.");
			
		}
		else
			System.out.println("The number is odd."); // if an integer divided by two, then that integer multiplied by two is different, then it's odd.
		
		
	}

}
