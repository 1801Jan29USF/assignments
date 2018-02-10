package question4;

import java.util.Scanner;

public class FactorialMain {
	
public static void main(String[] args) {
		ComputeNFactorial nFact = new ComputeNFactorial();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number to calculate it's factorial");
		int number = scan.nextInt();
		scan.close();
		nFact.computeFactorial(number);
	}

}
