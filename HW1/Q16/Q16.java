package com.revature.Q16;

public class Q16 {
	public static void main(String[] args) {
		
		String s = "";
		for (int i = 0; i < args.length; i++) {
			
			s = s + args[i];
		}
		System.out.println(s.length());
	}
}
