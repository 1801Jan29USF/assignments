package com.revature.singleton;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class ScannerSingleton /*implements Serializable*/ {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 3138084599007449487L;
	private static ScannerSingleton ss = new ScannerSingleton();
	private Scanner scan = new Scanner(System.in);
	private static Logger log = Logger.getRootLogger();
	
	private ScannerSingleton() {
		super();
		//log.info("Creating ScannerSingleton");
	}
	
	public static ScannerSingleton getScannerSingleton() {
		log.info("Returning this.ScannerSingleton");
		return ss;
	}
	
	public Scanner getScan() {
		log.info("Returning this.Scanner");
		return this.scan;
	}
	
	public String nextLine() {
		log.info("Scanning next line of strings");
		return getScan().nextLine();
	}
	
	public int nextInt() {
		log.info("Scanning next int");
		return getScan().nextInt();
	}
	
}
