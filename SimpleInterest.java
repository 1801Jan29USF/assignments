package com.revature.interest;
//Q17
import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the priciple amount");
		Integer input = scan.nextInt();
		System.out.println("Enter the amount of time in years: ");
		Integer input2 = scan.nextInt();
		System.out.println("Enter the rate as a decimal");
		double input3 = scan.nextDouble();
		
		double I = (double) (input*input2*input3);
		
		System.out.println(I);

	}

}
