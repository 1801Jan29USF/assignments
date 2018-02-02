package com.revature.q3;

import java.util.Scanner;

public class StringReverseLauncher {
	public static void main(String[] args) {
		StringReverser sr = new StringReverser();
		Scanner scan = new Scanner(System.in);
		String str = "a string";
		System.out.println("Forward: " + str);
		System.out.print("Reverse: ");
		System.out.println(sr.reverse(str));
		System.out.println("Enter a string you would like to reverse:");
		System.out.println(sr.reverse(scan.nextLine()));
	}
}
