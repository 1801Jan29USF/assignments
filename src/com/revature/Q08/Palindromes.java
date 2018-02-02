package com.revature.Q08;

import java.util.ArrayList;

public class Palindromes {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> palinDromes = new ArrayList<String>();

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

		/*
		 * Simply compare to the reversed string
		 */
		for (int i = 0; i < arr.size(); i++) {
			StringBuilder demo2 = new StringBuilder(arr.get(i));
			// StringBuilder objects do not override the equals() method,thus toString()
			if (demo2.toString().equals(demo2.reverse().toString())) {
				palinDromes.add(arr.get(i));

			}
		}
		System.out.println(palinDromes);

	}

}
