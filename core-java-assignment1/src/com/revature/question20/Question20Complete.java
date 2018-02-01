package com.revature.question20;

public class Question20Complete {
	public static void main(String[] args) {
		
		// Creating an object of my utility class.
		Question20Utility fileUtil = new Question20Utility();
		
		// Using my utility class, I read the line from the Data.txt file
		// and then split the first line read from the file into
		// an array of strings.
		String[] line = fileUtil.readLine(0).split(":");
		
		// Using well spaced sysout statements, I solve the problem.
		System.out.println("Name: " + line[0] + " " + line[1]);
		System.out.println("Age: " + line[2] + " years");
		System.out.println("State: " + line[3] + " State");
	}
}
