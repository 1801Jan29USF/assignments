package com.revature.Q17;

import java.util.Scanner;

public class Q17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principal");
		int principal = sc.nextInt();
		System.out.println("Enter the rate of interest");
		int rate = sc.nextInt();
		System.out.println("Enter the number of years");
		int time = sc.nextInt();
		sc.close();
		System.out.println(principal*rate*time);
	}
}
