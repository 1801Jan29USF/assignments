package Question13;

public class Q13Launcher {

	/**
	 * Prints a right triangle of alternating ones and zeroes of the given height
	 * 
	 * @param height
	 */
	public static void oneZeroTri(int height) {
		// A variable is needed to keep track of what to print next: a 1 or a 0
		int current = 0;
		/*
		 * This loop ensures the correct number of rows are printed; the counter
		 * determines the length of each row
		 */
		for (int i = 1; i <= height; i++) {
			// This loop prints the row, using current and i as a guide
			for (int j = 0; j < i; j++) {
				System.out.print(current + " ");
				if (current == 0) {
					current = 1;
				} else {
					current = 0;
				}
			}
			// Opens a new line
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// Prints a ones-and-zeroes triangle of height 4
		oneZeroTri(4);
	}
}
