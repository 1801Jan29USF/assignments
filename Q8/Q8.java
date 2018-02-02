package com.revature.Q8;

import java.util.ArrayList;

public class Q8 {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();
		
		al.add("karan");
		al.add("madam");
		al.add("tom");
		al.add("civic");
		al.add("radar");
		al.add("sexes");
		al.add("jimmy");
		al.add("kayak");
		al.add("john");
		al.add("refer");
		al.add("billy");
		al.add("did");
		//loop through al and reverse each string
		//and check if same as original
		for (int i = 0; i < al.size(); i++) {
			String myStringReversed = new StringBuilder(al.get(i)).reverse().toString();
			if (al.get(i).equals(myStringReversed)) {
				al2.add(al.get(i));
			}
		}
		System.out.println(al2);
	}
}
