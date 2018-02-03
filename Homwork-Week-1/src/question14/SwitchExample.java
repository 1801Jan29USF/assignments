package question14;

import java.util.Date;
import java.util.Scanner;

public class SwitchExample {
	
	Scanner scan = new Scanner(System.in);
	
	public SwitchExample prompt() {
	System.out.println("Enter 1 for to find square root of a number ");
	System.out.println("Enter 2 to dipslay today's date");
	System.out.println("Enter 3 to split 'I am learning Core java' and store it in a array");
	String input = scan.nextLine();
	

	double number = 100;
	
	switch(input) {
	case "1":
		number = Math.sqrt(number);
		System.out.println("The Square root is: " + number);
		break;
		
	case "2":
		Date date = new Date();
		System.out.println("Today's date is " + date);
		break;
		
	case "3":
		String st = "I am learning Java";
		String array[] = st.split(" ");
		for(String x:array) {
			System.out.println(x);
		}
		break;
	}
	return new SwitchExample();
	}
	
	
	
	public static void main(String[] args) {
		
		SwitchExample ex = new SwitchExample();
		while(true) {
			ex = ex.prompt();
			System.out.println("=================================");
		}
		
		
		
		

	}

}
