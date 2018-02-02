package com.revature.Q18;

public class TesterCase {
	public static void main(String[] args) {
		String s="I like to add 10 but ignore the rest";
		Shown see =new Shown();
		System.out.println(see.checkCase(s));
		System.out.println(see.upperCase(s));
		System.out.println(see.convertToInteger(s)+10);
	}
}
