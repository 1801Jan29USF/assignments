package com.revature.q3;

public class StringReverser {
	
	// blank constructor if no params are used when creating an object
	public StringReverser() {
		super();
	}
	
	public String reverse(String forStr) {
		int len = forStr.length();
		String[] strArr = forStr.split("", len);
		String revStr = "";
		for(int i = len-1; i >= 0; i--) {
			revStr = revStr+strArr[i];
		}
		return revStr;
	}
	
//	public String showReverse(String str) {
//		return reverse(str);
//	}

}
