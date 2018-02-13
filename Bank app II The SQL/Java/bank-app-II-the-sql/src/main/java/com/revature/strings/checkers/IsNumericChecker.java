package com.revature.strings.checkers;

import org.apache.log4j.Logger;

/**
 * Checks if a given String is numeric
 * 
 * @author Bobby McGetrick
 *
 */
public class IsNumericChecker {
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new IsNumericChecker
	 */
	public IsNumericChecker() {
		super();
		log.trace("Creating new IsNumericChecker");
		log.trace("Called super constructor - Object");
		log.trace("New WithdarwalScree created");
		log.trace("Prompting IsNumericChecker");
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve IsNumericChecker.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		return log;
	}
	
	/**
	 * Setting IsNumericChecker.log to a given Logger
	 * @return Logger log
	 */
	public static void setLog(Logger log) {
		IsNumericChecker.log = log;
	}



	/************************************************************************************
	 * Methods
	 ************************************************************************************/
	/**
	 * Checks if a given String is numeric
	 * 
	 * @param String str
	 * @return boolean
	 */
	public static boolean isNumeric(String str) {
		log.info("Checking if user input is a number");
		try {
			log.debug("User ipnut a number, converting input to a float");
			Float.parseFloat(str);
		} catch (NumberFormatException nfe) {
			log.debug("User input was not a number, reurning false");
			return false;
		}
		log.debug("User input was a number, reurning true");
		return true;
	}


}
