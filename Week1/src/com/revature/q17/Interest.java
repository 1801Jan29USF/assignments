package com.revature.q17;

import java.util.Scanner;

public class Interest {
	public static void main(String[] args) {
		double interest; 
		double Principle;
		double rate; 
		int time; 
		
		Scanner rates = new Scanner (System.in);
		System.out.println("Enter rate: ");
		double rt = rates.nextDouble();
		
		Scanner principles = new Scanner (System.in);
		System.out.println("Enter principle: ");
		double prncp = principles.nextDouble();
		
		
		Scanner times = new Scanner (System.in);
		System.out.println("Enter time: ");
		int tm = times.nextInt();
		
		interest = prncp * rt * tm; 
		
		System.out.println("Interest = " + interest);
		
	}
}
