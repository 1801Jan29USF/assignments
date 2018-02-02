package Question3;

public class Q3Launcher {
	/* Reverses an array without using a temporary variable */
	public static String reverseString(String reverseMe) {
		// Splits the string into an array of strings
		String[] splitString = reverseMe.split("");
		String returnMe = "";
		// Iterates backwards through the string array, aggregating each character into
		// a blank string
		for (int i = splitString.length - 1; i >= 0; i--) {
			returnMe += splitString[i];
		}
		return returnMe;
	}

	public static void main(String[] args) {
		System.out.println(reverseString("AnExample"));
	}

}
