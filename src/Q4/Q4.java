package Q4;

import java.util.Scanner;

public class Q4 {
	
	//compute n factorial
	public static void main(String[] args) {

		System.out.println("Enter a positive integer ");
		Scanner userInput = new Scanner(System.in);
		int n = userInput.nextInt();
		long result = n;

		if (n == 1) {
			System.out.println(1);
		} else if (n < 0) {
			System.out.println("Negative integer detected");
		} else {
			for (int i = 0; i < n; i++) {
				n--;
				result *= n;
			}
			System.out.println(result);	
		}
	}
}
