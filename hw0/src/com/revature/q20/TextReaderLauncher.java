package com.revature.q20;

public class TextReaderLauncher {
	public static void main(String[] args) {
		TextReader tr = new TextReader();
		
		String[] strArray = tr.readLine("Data.txt").split(":");
		System.out.println("Name: " + strArray[0] + " " + strArray[1]);
		System.out.println("Age: " + strArray[2]);
		System.out.println("State: " + strArray[3]);
	}
}
