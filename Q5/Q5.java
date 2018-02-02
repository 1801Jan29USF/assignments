package com.revature.Q5;

public class Q5 {

	static String newStringSub(String str, int idx) {
		char[] charArray = str.toCharArray();
		char[] subCharArray = new char[idx];
		//loop up to idx - 1 (inclusive) and
		//fill new char array
		for (int i = 0; i < idx; i++) {
			subCharArray[i] = charArray[i];
		}
		//convert char array to string
		return new String(subCharArray);
	}

	public static void main(String[] args) {
		String s = "Hello!";
		System.out.println(newStringSub(s, 3));
	}
}
