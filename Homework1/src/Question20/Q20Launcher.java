package Question20;

import java.io.File;
import java.util.Scanner;

/**
 * Reads the info from Data.txt and prints the information in a formatted style
 * 
 * @author poblo
 *
 */
public class Q20Launcher {

	public static void main(String[] args) throws Exception {
		// Create blank temporary fields outside of loop
		String currentLine;
		String[] parsedLine;
		// Opens the file and creates a scanner to read it
		File file = new File("src/Question20/Data.txt");
		Scanner sc = new Scanner(file);

		// Loops through each line, formatting and printing the information
		while (sc.hasNextLine()) {
			currentLine = sc.nextLine();
			parsedLine = currentLine.split(":");
			System.out.println("Name: " + parsedLine[0] + " " + parsedLine[1]);
			System.out.println("Age: " + parsedLine[2]);
			System.out.println("State: " + parsedLine[3]);
			System.out.println();

		}
		sc.close();

	}

}
