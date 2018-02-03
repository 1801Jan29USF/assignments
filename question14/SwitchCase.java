package question14;

import java.util.Date;
import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		
		Menue menue = new Menue();
		menue.displayMenue();
		Scanner sc = new Scanner(System.in);
		int selection = sc.nextInt();
		
		switch(selection) {
		
		case 1:
			System.out.println("Enter a number to calculate the square root");
			double num = sc.nextDouble();
			System.out.println("The square root of " + num + " = " + Math.sqrt(num));
			break;
		case 2:
			Date d = new Date();
			System.out.println(d);
			break;
		case 3:
			String str = "I am learning core Java";
			System.out.println("Around which character should we split the string?");
			String ch = sc.next();
			String[] split = str.split(ch);
			for(String s: split)
				System.out.println(s);
			break;
		default:
			System.out.println("Please select a valid option");
			break;
		}	
		
	}

}
