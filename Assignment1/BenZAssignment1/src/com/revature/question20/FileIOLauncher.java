package com.revature.question20;

import java.util.ArrayList;
import java.util.List;

public class FileIOLauncher {
	public static void main(String[] args) {
		FileIOUtility rl = new FileIOUtility();
		List<String> lines = new ArrayList<>();
		String[] tmpStrArr = new String[4];
		
		// Get all the lines into their own strings
		for(int i = 0; i < 4; i++) {
			lines.add(rl.readLine(i));
		}
		
		// Parse the strings
		// Hopefully there's a method for that
		for(String s : lines) {
			tmpStrArr = s.split(":");
			System.out.println("First Name: " + tmpStrArr[0]);
			System.out.println("Last Name: " + tmpStrArr[1]);
			System.out.println("Age: " + tmpStrArr[2]);
			System.out.println("Location: " + tmpStrArr[3]);
		}
		
		// Nice. Eclipse can't find my file. I'll figure it out in the morning or something.
	}
}
