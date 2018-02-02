package Question4;

public class Q4Launcher {

	/* Finds the factorial of a given number */
	public static long NFactorial(int factorMe) {
		// Creates a variable to aggregate the final result
		long agg = 1;
		long tracker = factorMe;
		/* Multiplies the given number by every previous whole number */
		while (tracker > 0) {
			agg *= tracker;
			tracker--;
		}
		return agg;
	}

	public static void main(String[] args) {
		System.out.print(NFactorial(20));
	}

}
