package com.revature.HQ13;

public class BinaryTriangle {

	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {				// loop to keep track of how many numbers are printed
			if(i%2 == 0) {							// condition to determine which binary digit is printed
				if(i == 2 || i == 4 || i == 7) {		// condition to determine which level digit is printed on
					System.out.println();
				}
				System.out.print(1);
			}
			else {
				if(i == 2 || i == 4 || i == 7) {		 // condition to determine which level digit is printed on
					System.out.println();
				}
				System.out.print(0);
			}
		}

	}

}
