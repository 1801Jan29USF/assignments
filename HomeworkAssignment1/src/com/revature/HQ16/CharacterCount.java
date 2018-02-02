package com.revature.HQ16;

import java.util.Scanner;

public class CharacterCount {

	public static void main(String[] args) {

		String x = args[0];
		int ans = 0;

		for(int i = 0; i < args.length; i++) {

			 x = args[i];
			 ans = ans + (x.length() + 1);
			System.out.println("The word \"" + x +"\" has " + x.length() + " characters.");
		}
		
		System.out.println("The total string has " + (ans - 1) + " characters.");
	}

}
