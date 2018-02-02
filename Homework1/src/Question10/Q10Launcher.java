package Question10;

public class Q10Launcher {

	public static void main(String[] args) {
		// Initializes ints for comparizon
		int a = 80;
		int b = 200;
		// Ternary operator judges that a is less than b and assigns a to minimumNum
		int minimumNum = (a < b) ? a : b;
		// Prints minimumNum
		System.out.println(minimumNum);
	}
}
