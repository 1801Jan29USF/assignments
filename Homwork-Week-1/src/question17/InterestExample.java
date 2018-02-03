package question17;

import java.util.Scanner;

public class InterestExample {

	public static void main(String[] args) {

		//creating scanner object, will allow user type in input into system
		Scanner scan = new Scanner(System.in);
		
		double interest, principal , rate, time;
		//User will be prompted to enter principal, rate and time which will be 
		//calculated to give the interest 
		
		System.out.println("Please enter the principal ");
		principal = scan.nextDouble();
		
		System.out.println("Please enter the rate ");
		rate = scan.nextDouble();
		
		System.out.println("Please enter the time ");
		time = scan.nextDouble();
		
		//simple mathematical calculation to calculate the interest
		interest = principal*rate*time;
		
		System.out.println("Your interest is $" +interest);

	}

}
