package question10;

import java.util.Scanner;

public class FindMinimum {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("To find the minimum of two integers");
		System.out.println("Enter the 1st integer");
		int num1 = scan.nextInt();
		System.out.println("Enter the 2nd integer");
		int num2 = scan.nextInt();
		int min = (num1 < num2) ? num1 : num2;
		System.out.println("The smallest integer is: " + min);
	}

}
