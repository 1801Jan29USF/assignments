package question8;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>(); // All string
		ArrayList<String> pal = new ArrayList<String>(); // Palindrome strings
		// add all string in arr
		arr.add("karan");
		arr.add("madam");
		arr.add("tom");
		arr.add("civic");
		arr.add("radar");
		arr.add("jimmy");
		arr.add("kayak");
		arr.add("john");
		arr.add("refer");
		arr.add("billy");
		arr.add("did");
		// loop each element in arr
		for (int i = 0; i < arr.size(); i++) {
		if (isPalindrome((String) arr.get(i))) { // if palindrome
		pal.add((String) arr.get(i)); // add the string to pal list
		}
		}
		System.out.println("The Palindrome string are : " + pal);
		}

		public static boolean isPalindrome(String str) {
		String reverse = "";
		// reverse the string
		for (int i = str.length() - 1; i >= 0; i--) {
		reverse = reverse + str.charAt(i);
		}
		// check string matches to give string
		return str.equals(reverse);
		}

}
