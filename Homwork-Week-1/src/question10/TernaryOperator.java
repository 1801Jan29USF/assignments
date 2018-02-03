package question10;

import java.util.Scanner;

public class TernaryOperator {
	
	public static void main(String[] args) {
		
		//used scanner to enter two number 
		Scanner scan = new Scanner(System.in);
		int number1;
		int number2;
		int min;
		
		System.out.println("Please enter firs number");
		number1 = scan.nextInt();
		
		System.out.println("Please enter second number");
		number2 = scan.nextInt();
		
		//used ternary operator to find the minimum of the two numbers entered. 
		min = (number1<number2) ? number1: number2;
		
		System.out.println("The minimum number is " + min);
		
	}
	


}
