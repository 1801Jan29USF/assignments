package com.revature.question8;

import java.util.ArrayList;

public class Question8Complete {
	public static void main(String[] args) {
		
		// Creates two arraylists to store my strings.
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		
		// Manually add all of the strings to the first string.
		arr.add("karan");
		arr.add("madam");
		arr.add("tom");
		arr.add("civic");
		arr.add("radar");
		arr.add("sexes");
		arr.add("jimmy");
		arr.add("kayak");
		arr.add("john");
		arr.add("refer");
		arr.add("billy");
		arr.add("did");
		
		// A for loop with an if loop that checks if the input string is a palindrome,
		// then if that string is a palindrome, enters it into the second string.
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).equals(new StringBuffer(arr.get(i)).reverse().toString())) {
				arr2.add(arr.get(i));
			}
		}
		
		// A for loop to print all of the strings in the second string.
		for(int i = 0; i < arr2.size(); i++) {
			System.out.println(arr2.get(i));
		}
	}
}