package com.revature.HQ8;

import java.util.ArrayList;

public class Palindromes {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> Palindromes = new ArrayList<String>();
		
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		for(int i = 0; i < words.size(); i++) {
			
			if(isPalindrome(words.get(i))) {
				
				Palindromes.add(words.get(i));
			}
		}
		
		for(int i = 0; i < Palindromes.size(); i++) {
			System.out.println(Palindromes.get(i));
		}

	}
	
	public static boolean isPalindrome(String S) {
		int i, N = S.length();

		for (i = 0; i < N / 2; i++) {
			if (S.charAt(i) != S.charAt(N - i - 1)) {
				return false;
			}
		}

		return true;
	}

}
