package com.revature.q18;

public class StringManipLaucnher {
	public static void main(String[] args) {
		StringManipulator sm = new StringManipulator();
		
		System.out.println(sm.checkForUpper("I have an Upper Case Letter"));
		System.out.println(sm.checkForUpper("i have no upper case letters"));
		String str = "dialate my letters";
		System.out.println(str + " " + sm.convertToUpper(str) + " ...thanks");
		System.out.println("Converting 5 to an int and adding 10... " + sm.convertToIntPlus10("5"));
	}
}
