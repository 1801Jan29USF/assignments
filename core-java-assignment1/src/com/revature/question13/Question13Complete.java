package com.revature.question13;

public class Question13Complete {
	public static void main(String[] args) {
		// I use nested for loops to get the pattern asked for
		// my loops only iterate once, and I have spaces added when needed
		for (int i = 0; i < 1; i++) {
			System.out.println(0);

			for (int j = 0; j < 1; j++) {
				System.out.print(1 + " ");
				System.out.println(0);

				for (int k = 0; k < 1; k++) {
					System.out.print(1 + " ");
					System.out.print(0 + " ");
					System.out.println(1);

					for (int l = 0; l < 1; l++) {
						System.out.print(0 + " ");
						System.out.print(1 + " ");
						System.out.print(0 + " ");
						System.out.println(1);
					}
				}
			}
		}
	}
}
