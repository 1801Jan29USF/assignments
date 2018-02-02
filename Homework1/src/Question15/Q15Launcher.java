package Question15;

public class Q15Launcher {

	public static void main(String[] args) {
		// Creates two integer variables for testing purposes
		int a = 30;
		int b = 15;
		// Creates a new instance of the utility class ThoroughMaths
		ThoroughMaths mathMan = new ThoroughMaths();
		// Tests addition on a and b
		System.out.println(mathMan.add(a, b));
		// tests division on a and b
		System.out.println(mathMan.division(a, b));
		// Tests subtraction on a and b
		System.out.println(mathMan.subtract(a, b));
		// Tests multiplication on a and b
		System.out.println(mathMan.multiply(a, b));
	}
}
