package Question15;

/**
 * A class implementing basic arithmetic operations. Adds implementations for
 * ass, subtract, multiply and divide
 * 
 * @author poblo
 *
 */
public class ThoroughMaths implements QuickMaths {

	// Adds two integers
	public int add(int first, int second) {
		return first + second;
	}

	// Subtracts two integers
	public int subtract(int first, int second) {
		return first - second;
	}

	// Multiplies two integers
	public int multiply(int first, int second) {
		return first * second;
	}

	// Divides two integers. The remainder will be discarded.
	public int division(int first, int second) {
		return first / second;
	}
}
