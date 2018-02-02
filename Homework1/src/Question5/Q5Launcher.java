package Question5;

public class Q5Launcher {

	/* Returns a string consisting of the first n characters of a given string */
	public static String selectFirst(String input, int firstX) {
		// Splits the string into an array of character-strings
		String[] divided = input.split("");
		// Creates a blank string to aggregate the final result
		String returnMe = "";
		/*
		 * Iterates through the first n items of the string array, aggregating the first
		 * n characters into a blank string
		 */
		for (int i = 0; i < firstX; i++) {
			returnMe += divided[i];
		}

		return returnMe;
	}

	public static void main(String[] args) {
		System.out.println(selectFirst("NARWHALSNARWHALS", 8));
	}

}
