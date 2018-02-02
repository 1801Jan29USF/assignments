package com.revature.Q18;

public class Shown extends Hidden {

	@Override
	public boolean checkCase(String s) {
		
		// Returns true by checking the ASCII code for upper case characters
		for (int i = 0; i < s.length(); i++)
			if (s.codePointAt(i) >= 65 && s.codePointAt(i) <= 90)
				return true;
		return false;
	}

	// We can check character by character or just simply call s.toUpperCase() on the whole string.
	@Override
	public String upperCase(String s) {
		String c = "";
		for (int i = 0; i < s.length(); i++) {

			if (s.codePointAt(i) >= 97 && s.codePointAt(i) <= 122) {

				c += String.valueOf((s.charAt(i))).toUpperCase();

			} else
				c += String.valueOf(s.charAt(i));
		}
		return c;

	}

	@Override
	public int convertToInteger(String s) {
		return Integer.parseInt(s.replaceAll("[\\D]", ""));
	}

}
