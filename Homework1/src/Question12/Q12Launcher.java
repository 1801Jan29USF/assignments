package Question12;

public class Q12Launcher {

	public static void main(String[] args) {
		// Creates a new array and fills it with the values 1 to 100
		int[] toHundred = new int[100];
		for (int i = 1; i <= 100; i++) {
			toHundred[i - 1] = i;
		}
		// Prints out only the even numbers from the array toHundred
		for (int i : toHundred) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

	}

}
