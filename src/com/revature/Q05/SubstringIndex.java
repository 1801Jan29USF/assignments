package com.revature.Q05;

public class SubstringIndex {

	public static void main(String[] args) {
		SubstringIndex i = new SubstringIndex();
		System.out.println(i.subInd("Superman", 4));

	}

	/*
	 * Obtain the substring of a number from 0 to specified index. uses the charat()
	 * method to find characters and pass it to a character array
	 */
	String subInd(String str, int i) {
		char[] charArr = new char[str.length()];
		for (int j = 0; j <= i - 1; j++) {

			charArr[j] = str.charAt(j);
		}
		str = String.valueOf(charArr);
		return str;
	}
}
