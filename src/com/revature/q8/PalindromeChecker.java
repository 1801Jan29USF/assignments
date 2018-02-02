package com.revature.q8;

import com.revature.q3.StringReverser;

public class PalindromeChecker {
	
	private StringReverser sr = new StringReverser();

	public PalindromeChecker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isPalindrome(String str) {
		String revStr = sr.reverse(str);
		if (str.equals(revStr))
			return true;
		return false;
	}

}
