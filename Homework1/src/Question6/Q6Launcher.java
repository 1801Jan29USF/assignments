package Question6;

public class Q6Launcher {

	/* Evaluates whether or not a number is even without using % */
	public static boolean isEven(int judgeMe) {
		// Assumes number is odd unless otherwise demonstrated
		boolean even = false;
		// Converts the integer into a string, and splits it into an array of string
		// characters
		String[] judgeString = Integer.toString(judgeMe).split("");
		// Takes the last item of that string array
		String lastDigit = judgeString[judgeString.length - 1];
		// Converts that item back into an integer, thus retrieving the final digit of
		// th integer
		int criticalDigit = Integer.parseInt(lastDigit);
		/*
		 * Tests whether the last digit is even. This determines if the number is even.
		 * Changes the answer to true if the number is proven even.
		 */
		switch (criticalDigit) {
		case 0:
			even = true;
			break;
		case 2:
			even = true;
			break;
		case 4:
			even = true;
			break;
		case 6:
			even = true;
			break;
		case 8:
			even = true;
			break;
		}

		return even;

	}

	public static void main(String[] args) {
		System.out.println(isEven(171));
		System.out.println(isEven(857867978));
		System.out.println(isEven(3));
		System.out.println(isEven(222));
		System.out.println(isEven(175));
		System.out.println(isEven(38386));
		System.out.println(isEven(99999));

	}

}
