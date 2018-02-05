package com.revature.q5;

public class SubStringer {

	public SubStringer() {
		super();
	}
	
	public String subString(String str, int idx) {
		Character spliter = str.charAt(idx);
		String[] subStr = str.split(spliter.toString(), idx);
		return subStr[0];
		
	}
	
}
