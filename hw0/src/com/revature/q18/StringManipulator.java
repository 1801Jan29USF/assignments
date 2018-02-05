package com.revature.q18;

public class StringManipulator extends StringManipulation {

	@Override
	public boolean checkForUpper(String str) {
		return !str.equals(str.toLowerCase());
	}

	@Override
	public String convertToUpper(String str) {
		return str.toUpperCase();
	}

	@Override
	public int convertToIntPlus10(String str) {
		return Integer.parseInt(str) + 10;
	}

}
