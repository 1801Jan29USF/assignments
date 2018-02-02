package com.revature.Q16;

/*
 * Passed arguments using command line into args
 */
public class CommandArgument {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i].length());
		}
	}
}
