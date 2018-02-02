package Question14;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Q14Launcher {

	public static void main(String[] args) {
		// Selects random switch case to execute
		Random rand = new Random();
		int a = rand.nextInt(3) + 1;
		// Switch function demonstrating three different functionalities
		switch (a) {
		case 1:
			// Prints square root of givenNumer (square root of 20)
			int givenNumber = 20;
			System.out.println(Math.sqrt(givenNumber));
			break;
		case 2:
			// Prints the current date and time
			Date currentDate = Calendar.getInstance().getTime();
			System.out.println(currentDate);
			break;
		case 3:
			// Splits the given string into an array of string-characters, then prints the
			// first
			String[] splitString = "I am learning Core Java".split("");
			for (int i = 0; i < splitString.length; i++) {
				System.out.println(splitString[i]);
			}
			break;
		}

	}

}
