package question3;

import java.util.Scanner;

public class StringController {
	
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		Scanner scan = new Scanner(System.in);
		System.out.println("Type a string");
		String st = scan.nextLine();
		rs.setString(st);
		scan.close();
		rs.reverseString();
		rs.printNewString();
	}

}
