package com.revature.Q13;

public class Triangle {

	public static void main(String[] args) {

		// Makes sure we only get 4 lines
		for (int i = 1; i <= 4; i++) {
			int control = 0;
			// Input 1 or zero according to the control variable
			for (int j = 1; j <= i; j++) {
				if (control != 1 && i != 4)
					control = 1;
				else if (i == 4 && j % 2 == 0)
					control = 1;
				else
					control = 0;
				System.out.print(control + " ");

			}

			// Print one new line after inner loop is done
			System.out.print("\n");
		}

	}

}
