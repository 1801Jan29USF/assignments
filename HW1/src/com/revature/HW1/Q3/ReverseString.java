package com.revature.HW1.Q3;

public class ReverseString {
	public static void main(String[] args) {
		reverse("hello world");

	}

	private static void reverse(String input) { // method to reverse string
		int x = input.length(); // length of the string being passed
		String newstring = "";
		for (int i = input.length() - 1; i >= 0; i--) { // iterates backwards starting at the final character in the
														// string
			newstring += input.charAt(i); // Adds the character at the corresponding mirrored index.
			// input = input.substring(x);

		}

		System.out.println(newstring); // outputs new string to console
	}
}
