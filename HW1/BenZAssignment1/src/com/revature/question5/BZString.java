package com.revature.question5;

public class BZString {

	public String bzSubStr(String str, int index) {
		StringBuilder newStr = new StringBuilder();

		// Iterate through string by character
		// Append on to our string builder
		for(int i = 0; i <= index; i++) {
			System.out.println(str.charAt(i));
			newStr.append(str.charAt(i));
		}
		System.out.println(newStr);
		str = newStr.toString();
		
		return str;
	}

	
	
	
}
