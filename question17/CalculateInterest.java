package question17;

import java.util.Scanner;

public class CalculateInterest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the principle/loan amount: ");
		double principle = sc.nextDouble();
		System.out.println("Enter the rate of interest: ");
		double rate = sc.nextDouble();
		System.out.println("Enter the number of years for the loan: ");
		int years = sc.nextInt();
		// calculate the interest on a loan given principle, rate, and time in years
		double interest = principle * rate * years;
		
		System.out.println("The amount of interest you will pay is: $" + interest);
	}

}
