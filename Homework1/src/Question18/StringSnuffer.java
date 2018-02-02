package Question18;

/**
 * Implements StringSniffer, defining a method that checks a string for capital
 * letters, a method that converts a string to capital letters, and a method
 * that converts a string to integer and adds 10;
 * 
 * @author poblo
 *
 */
public class StringSnuffer extends StringSniffer {

	/**
	 * returns true if a string contains at least one uppercase letter
	 */
	@Override
	public boolean hasCaps(String input) {
		char ch;
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			if (Character.isUpperCase(ch)) {
				return true;
			}
		}
		return false ;
	}

	/**
	 * Returns a string identical to the given string, but every letter is uppercase
	 */
	@Override
	public String toUppercase(String input) {
		return input.toUpperCase();
	}

	/**
	 * Converts a string to and integer and adds 10. Returns the result. Presumes
	 * that the string represents an integer.
	 */
	@Override
	public void add10(String input) {
		int sInt = Integer.parseInt(input);
		System.out.println(sInt + 10);

	}

}
