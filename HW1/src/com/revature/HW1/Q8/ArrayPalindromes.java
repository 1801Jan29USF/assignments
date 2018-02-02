package com.revature.HW1.Q8;

import java.util.*;

public class ArrayPalindromes {
	static ArrayList<String> list = new ArrayList<>();
	static ArrayList<String> pallist = new ArrayList<>();
	
	public static void main(String[] args) {
		
	list.add("karan");  //adding all of these to the list
	list.add("madam");
	list.add("tom");
	list.add("civic");
	list.add("radar");
	list.add("sexes");
	list.add("jimmy");
	list.add("kayak");
	list.add("john");
	list.add("refer");
	list.add("billy");
	list.add("did");
	
	System.out.println(list);
	isPal(list);
	System.out.println(pallist);

	}

	static void addtoList(String s) {
		list.add(s);
	
	}

	static void isPal(ArrayList<String> s) { // method to compare letters in a word from front to back
		for (String string : s) {

			int frontletter = 0;
			int backletter = string.length() - 1;

			while (frontletter < backletter) { // while the compared letters have yet to meet in the middle,
				if (!(string.charAt((frontletter++)) == (string.charAt(backletter--)))) { // if the front letter's character is not equal to the last letter's character, end the loop as they're already not palindromes
					break;
				}
				else
					pallist.add(string); //adds it to the list and stops the operations
					break;
			}
		}

	}

}
