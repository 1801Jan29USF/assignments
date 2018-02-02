package com.revature.HW1.Q18;

public class SubclassFun extends SuperAbstract {

	public static void main(String[] args) {

		SubclassFun fun = new SubclassFun(); // object as the methods aren't static

		String mystring = "Hello to the world."; // String with single uppercase value passed to anyUpper()
		String mylowerstring = "i have no upper case.";
		String intstring = "15"; // String with integer characters for parsing.

		// anyUpperCase()
		System.out.println(fun.anyUppercase(mystring));
		System.out.println(fun.anyUppercase(mylowerstring));
		// makeUpper()
		System.out.println(fun.makeUpper(mystring));
		// add10()
		System.out.println(fun.add10(intstring));
		System.out.println(fun.add10(mystring));

	}

	@Override

	boolean anyUppercase(String s) {
		boolean anyUpper;
		return anyUpper = !s.equals(s.toLowerCase()); // converts the string to full lower case, and checks for
														// equality. If they're the same, then no upper cases were
														// changed
	}

	@Override
	String makeUpper(String s) {
		String result = "";

		result = s.toUpperCase(); // returns a .toUpperCase() string of the given input

		return result;
	}

	@Override
	int add10(String s) {
		int convert = 0;
		try {
			convert = Integer.parseInt(s); // parses string as integer, adds 10;
		} catch (NumberFormatException e) {
			System.out.println("Invalid string input, returning zero.");
			return 0; // returns zero if the input is invalid, just having fun playing with try catch
						// blocks.

		}
		return convert + 10;
	}

}
