package com.revature.q20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextReader {
	
	public TextReader() {
		super();
	}

	public String readLine(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			return br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
