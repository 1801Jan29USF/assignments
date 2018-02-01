package com.revature.question16;

public class Question16Complete {
	public static void main(String[] args) {
		
		// Using an enhanced for loop, iterates through the command line arguments 
		// and using the String length method, displays the number of characters
		// of all the command line arguments
		
		for (String s: args) {
            System.out.println("The number of characters in the input command line arguments are: " + s.length());
        }
	}
}