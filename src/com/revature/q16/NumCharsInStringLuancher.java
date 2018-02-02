package com.revature.q16;

public class NumCharsInStringLuancher {
	
	public static void main(String[] args) {
		// assuming entire line is one string including whitespace
		String str = "";
		for (String s : args) 
			str = str + s;
		System.out.println(str.length());
		
		// only using 1st arg
		System.out.println(args[0].length()); // only using 1st arg
	}

}
