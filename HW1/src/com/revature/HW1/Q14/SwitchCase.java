package com.revature.HW1.Q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SwitchCase {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String string = "I am learning Core Java.";

		System.out.println("Choose an option: "); // prompts user for selection
		System.out.println("Type 1 to find the square root of a number.");
		System.out.println("Type 2 to display today's date.");
		System.out.println("Type 3 to split the string " + '"' + "I am learning Core Java" + '"' + '.');
		// user provides input

		String input = scan.nextLine();

		switch (input) {
		case "1":
			// uses math.sqrt to return sqrt of given int
			System.out.println("Square root of what number? Provide an integer.");
			int given = scan.nextInt();
			System.out.println("The square root is: " + Math.sqrt(given));

			break;
		case "2":
			// imported date formatting
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			System.out.println("The date is " + dateFormat.format(date));

			break;

		case "3":
			// splits hardcoded string and outputs to console, using space as delimiter
			String[] splitarray;
			splitarray = string.split(" ");

			for (String s : splitarray) {
				System.out.println(s);
			}

		}
	}

}
