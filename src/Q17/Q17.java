package Q17;

import java.util.Scanner;

public class Q17 {
	
	//prompt user and calculate interest
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter principal");
		double principal = scan.nextDouble();
		System.out.println("enter rate");
		double rate = scan.nextDouble();
		System.out.println("enter time");
		double time = scan.nextDouble();
		System.out.println("Interest = " + principal * rate * time);
	}
}
