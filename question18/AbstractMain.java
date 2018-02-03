package question18;

import java.util.Scanner;

public class AbstractMain {

	public static void main(String[] args) {
		
		SubClass sub = new SubClass();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Type a string to check for uppercases: ");
		String stCheck = sc.nextLine();
		boolean bool = sub.uppercaseChecker(stCheck);
		if(bool) {
			System.out.println("There are uppercase characters in this string. \n");
		} else {
			System.out.println("There are NO uppercase characters in this string. \n");
		}
		
		System.out.println("Type a string to convert to all UPPERCASE: ");
		String stConvert = sc.nextLine();
		System.out.println(sub.uppercaseConverter(stConvert));
		
		System.out.println("Type a string to convert to integer plus 10: ");
		String stToInt = sc.nextLine();
		sub.addTen(stToInt);
	}

}
