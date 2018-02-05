package com.revature.util;

import java.util.Scanner;

/**
 * Holds a Scanner object that collects user input from the command line so that
 * it never has to be re-initialized or closed, and no more than one needs
 * to be made.
 * @author poblo
 *
 */
public class CommandLineScannerSingleton {
	private static CommandLineScannerSingleton s = new CommandLineScannerSingleton();
	private static Scanner sc = new Scanner(System.in);
	
	private CommandLineScannerSingleton() {
		super();
	}
	
	public static CommandLineScannerSingleton getSingleton() {
		return s;
	}

	public static Scanner getSc() {
		return sc;
	}
	


}
