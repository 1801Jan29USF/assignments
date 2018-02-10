package question6;

import java.util.Scanner;

public class EvenMain {

	public static void main(String[] args) {
		
		EvenChecker check = new EvenChecker();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an integer");
		int num = scan.nextInt();
		check.checkIt(num);
		scan.close();		
	}
}
