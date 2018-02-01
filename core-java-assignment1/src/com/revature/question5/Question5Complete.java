package com.revature.question5;

public class Question5Complete {
	public static void main(String[] args) {

		// My example string
		String str = "hallo";

		// sysout to display the substring
		System.out.println("The substring between index 0 and the index 3 - 1 is: " + substringMethod(str, 3));
	}

	// My substring method. It takes an input string and index,
	// and, using a for loop, returns the substring between the indices 0 
	// and idx - 1
	public static String substringMethod(String str, int idx) {
		String temp = "";
		for (int i = 0; i < idx - 1; i++) {
			temp += str.charAt(i);
		}
		return temp;
	}
}
