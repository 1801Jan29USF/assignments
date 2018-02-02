package com.revature.HW1.Q5;

public class SubstringMethod {
	public static void main(String[] args) {

		String mystring = "Hello to the world and Blake when he grades this.";

		System.out.println(substr(mystring, 15));

	}

	// manually built static method to append each char of a string up to the given
	// index
	private static String substr(String str, int idx) {

		String result = "";

		for (int i = 0; i < idx; i++) {
			result += str.charAt(i);
		}

		return result;
	}

}
