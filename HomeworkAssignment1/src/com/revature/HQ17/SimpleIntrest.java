package com.revature.HQ17;

import java.util.Scanner;

public class SimpleIntrest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double Interest = 0;
		double Principal = 0;
		double Rate = 0;
		double Time = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the principal: ");
		Principal = scan.nextDouble();
		System.out.println("Please enter the rate: ");
		Rate = scan.nextDouble();
		System.out.println("Please enter time in years: ");
		Time = scan.nextDouble();
		System.out.println(Interest = Principal * Rate * Time);
	}

}
