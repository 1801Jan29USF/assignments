package com.revature.Q6;

public class Q6 {

	static void evenOrOdd(int number) {
		//if number is odd then it is 
		//rounded down when divided in half
		int q = number / 2;
		//if even, number is not down-rounded
		//and will equal original when multiplied by 2
		if ((q * 2) == number) {
			System.out.println("Number is even!");
		} 
		else {
			System.out.println("Number is not even!");
		}
	}

	public static void main(String[] args) {
		int num = -26;
		evenOrOdd(num);
		
	}
}
