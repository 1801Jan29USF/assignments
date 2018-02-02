package com.revature.HW1.Q16;

/**
 * I add string input through Run -> Run Configurations -> Arguments -> "This is
 * my string" as the command line argument.
 * 
 * @author Brandon
 *
 */
public class NumOfChars {
	public static void main(String[] args) {
		String result = "";

		for (String s : args) { //for each string in args, combine them into new string.
			result += s;
		}

		System.out.println("Our string:  " + result + " has " + result.length() + " characters.");

	}

}
