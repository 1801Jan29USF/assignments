package com.revature.util.singleton.input;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Wraps a Scanner in a singleton for use with the banking application
 * 
 * @author Bobby McGetrick
 *
 */
public class ScannerSingleton {

	/************************************************************************************
	 * Private Fields
	 ************************************************************************************/
	private static ScannerSingleton ss = new ScannerSingleton();
	private Scanner scan = new Scanner(System.in);
	private static Logger log = Logger.getRootLogger();
	
	/************************************************************************************
	 * Private constructors
	 ************************************************************************************/
	/**
	 * Create new ScannerSingleton
	 */
	private ScannerSingleton() {
		super();
	}
	
	/**
	 * Return a ScannerSingleton to setup a Scanner Singleton
	 * @return ScannerSingleton
	 */
	public static ScannerSingleton getScannerSingleton() {
		log.trace("Returning this.ScannerSingleton");
		return ss;
	}
	
	/**
	 * Retrieve ScannerSingleton.scan
	 * @return Scanner scan
	 */
	public Scanner getScan() {
		log.trace("Returning this.Scanner");
		return this.scan;
	}
	
	/**
	 * Scan the next line of user input as a String
	 * @return String
	 */
	public String nextLine() {
		log.trace("Scanning next line of user input String");
		return getScan().nextLine();
	}
	
	/**
	 * Scan the next integer of user input
	 * @return int
	 */
	public int nextInt() {
		log.trace("Scanning next int");
		return getScan().nextInt();
	}
	
}
