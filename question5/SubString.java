package question5;

import java.util.Scanner;

public class SubString {
	
	StringBuilder sb = new StringBuilder();
	
	private String subStringMethod(String str, int idx) {
		for(int i = 0; i <= idx-1; i++) {
			sb.append(str.charAt(i));
		}		
		return sb.toString();
	}

	public static void main(String[] args) {
		SubString ss = new SubString();
		System.out.println("Enter a string");
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		System.out.println("At what index should the substring end?");
		int index = scan.nextInt();
		String sub = ss.subStringMethod(string, index);
		scan.close();
		System.out.println("The sub-string is: " + sub);
		
	}

}
