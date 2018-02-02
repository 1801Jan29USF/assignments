package Question8;

import java.util.ArrayList;
import java.util.Arrays;

public class Q8Launcher {

	// Returns true if the given string is a palindrome
	public static boolean isPalindrome(String input) {
		boolean isP = false;
		// creates a reverse copy of the string
		String reverse = new StringBuffer(input).reverse().toString();
		// If the string is identical to its reverse copy, it is a palindrome
		if (input.equals(reverse)) {
			isP = true;
		}
		return isP;
	}

	/*
	 * Iterates through a given arraylist of strings, returning an arraylist
	 * containing the palindromes in that arraylist
	 */
	public static ArrayList<String> palindromeArray(ArrayList<String> inArray) {
		String selector;
		// Creates a blank arraylist to be loaded with palindromes
		ArrayList<String> outArray = new ArrayList<String>();
		// Iterates through the input arraylist to select each member
		for (int i = 0; i < inArray.size(); i++) {
			selector = inArray.get(i);
			// If the member is a palindrome, it is added to the output arraylist
			if (isPalindrome(selector)) {
				outArray.add(selector);
			}
		}
		return outArray;
	}

	public static void main(String[] args) {
		// This is the arraylist given by the assignment
		ArrayList<String> givenArray = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar",
				"sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		// if the function palindromeArray does its job, this new arraylist contains all
		// the palindromes from givenArray
		ArrayList<String> palindromes = palindromeArray(givenArray);
		// prints the palindromes
		for (int i = 0; i < palindromes.size(); i++) {
			System.out.println(palindromes.get(i));
		}

	}

}
