package com.revature.Q20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q20 {

	public static void main(String[] args) {
		try (BufferedWriter os = new BufferedWriter(new FileWriter("Data.txt"))) {
			os.write("Mickey:Mouse:35:Arizona\nHulk:Hogan:50:Virginia\n"
					+ "Roger:Rabbit:22:California\nWonder:Woman:18:Montana");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
			line = br.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String name = line.substring(0, 6) + " " + line.substring(7, 12);
		String age = line.substring(13, 15) + " years";
		String state = line.substring(16, 23) + " State";

		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("State: " + state);

	}
}
