package com.revature.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


// A utility class that simply creates a read line method using BufferedReader
// and has a hard-coded link to the Data.txt file.
public class Question20Utility {
	public String readLine(int lineNumber) {
		try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
			for (int i = 0; i < lineNumber; i++) {
				br.readLine();
			}
			return br.readLine();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occured while reading.");
			e.printStackTrace();
		}
		return null;
	}
}