package com.revature.question20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOUtility {

	public String readLine(int lineNumber) {
		try(BufferedReader br = new BufferedReader(new FileReader("Data.txt"))){
			for(int i = 0; i < lineNumber; i++) {
				br.readLine();
			}
			return br.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
