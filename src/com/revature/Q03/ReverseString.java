package com.revature.Q03;

public class ReverseString {

	public static void main(String[] args) {
		String mine = "hello";
		int length = mine.length();
		// Reversing string
		for (int i = mine.length(); i > 0; i--) {

			// Concat reverse to original
			mine = mine.concat(mine.substring(i - 1, i));

		}
		// Extract original
		mine = mine.substring(length);
		System.out.println(mine);
	}
}
