//Q8
package com.revature.palindromes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Palindrome {
	
	

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("civic");

		
		List<String> p = new ArrayList<String>();//origonal array
		List<String>dome = new ArrayList<>();//palindrome array
		
		p.add("karan");
		p.add("madam");
		p.add("tom");
		p.add("civic");
		p.add("radar");
		p.add("sexes");
		p.add("jimmy");
		p.add("kayak");
		p.add("john");
		p.add("refer");
		p.add("billy");
		p.add("did");
	

		
		for (int i = 0; i <= p.size()-1; i++) {
			StringBuilder pan = new StringBuilder(p.get(i));
			String r =pan.reverse().toString();
			if(p.get(i).equals(r)) {
				
				dome.add(p.get(i));
				
				
			}
			
			
		}
		System.out.println(dome.get(0));
			
				
	}
}


