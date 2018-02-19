package com.revature.question16;

public class CmdLineArgs {
	public static void main(String[] args) {
		// Well, I don't know how to put in cmd line arguments in eclipse but this should work.
		// Just trying to count how many characters right?
		// If you wanted each individual string counted you just wouldn't do += and would put the print inside the loop.
		// Or store it in a list if you needed it for later (list because it needs to be dynamic)
		// ... unless its like c where one of the arguments is the number of arguments
		int sum = 0;
		for(String s : args) {
			sum += s.length();
		}
		System.out.println(sum);
	}
}
