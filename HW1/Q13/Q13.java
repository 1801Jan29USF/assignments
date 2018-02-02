package com.revature.Q13;

public class Q13 {
	public static void main(String[] args) {
		int n = 0;
		int j = 0;
		int k = 0;

		while (j < 4) {

			while (k <= j) {
				System.out.print(n + " ");
				// n is a 0 (change to 1)
				if (n == 0) {
					n++;
				}
				// n is 0 (change to 0)
				else {
					n--;
				}
				//next column
				++k;
			}
			System.out.print(System.lineSeparator());
			System.out.print(System.lineSeparator());
			//reset column
			k = 0;
			//next row
			++j;
		}
	}
}
