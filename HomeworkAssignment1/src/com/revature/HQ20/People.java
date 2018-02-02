package com.revature.HQ20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class People {
	private static String name;
	private static int age;
	private static String state;
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 4; i++) {
			System.out.println(readLine(i));
		}
		System.out.println();
		
		for(int i = 0; i < 4; i++) {
			String str = readLine(i);
			String delimiter = ":";
			String[] temp;
			temp = str.split(delimiter);
			
			name = temp[0] + " " + temp[1];
			age = Integer.parseInt(temp[2]);
			state = temp[3];
			
			System.out.println("Name: " + name);
			System.out.println("Age: " + age + " years");
			System.out.println("State: " + state + " State");
			System.out.println();
		}
	}
	
	private static String readLine(int lineNumber) {
		
		try(BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
			for (int i = 0; i < lineNumber; i++) {
				br.readLine();
			}
			return br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
