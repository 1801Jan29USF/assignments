package Question16;

public class Q16Launcher {

	/**
	 * Class takes any command line string and returns the length. Assumes that the user
	 * inputs unformatted text into the command line without the use of "".
	 * @param args
	 */
	public static void main(String[] args) {
		// Sends a message to the command line if user did not input and argument
		if (args.length == 0) {
			System.out.println("You must input a string");
			return;
		}
		// Creates an aggregate value for later use
		int agg = 0;
		// Iterate through each word of the input string, adding the length of each to
		// the aggregate
		for (int i = 0; i < args.length; i++) {
			agg += args[i].length();
		}
		// Add the spaces to the length. There will be a space after each input, except
		// the last.
		agg += args.length - 1;

		// Outputs the length of the input string
		System.out.println(agg);

	}

}
