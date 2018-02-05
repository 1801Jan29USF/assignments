package com.revature.q8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeLauncher {
	
	public static void main(String[] args) {
		List<String> strArray = new ArrayList<>();
		List<String> palindromes = new ArrayList<>();
		Scanner scan = new Scanner(System.in);		
		String input;
		PalindromeChecker pc = new PalindromeChecker();
		
		do {
			System.out.println("Enter the word you would like to add to the ArrayList (0 to finish adding):");
			input = scan.nextLine();
			strArray.add(input);
		} while (!input.equals("0"));
		scan.close();
		strArray.remove(strArray.size()-1);
		
		for (String str : strArray) {
			if (pc.isPalindrome(str))
				palindromes.add(str);
		}
		
		System.out.println("Palindromes that you entered:");
		for (String str : palindromes)
			System.out.println(str);
		
	}

}
