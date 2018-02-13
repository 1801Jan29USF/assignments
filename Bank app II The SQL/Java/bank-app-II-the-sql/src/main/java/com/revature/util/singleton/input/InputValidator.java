package com.revature.util.singleton.input;

import org.apache.log4j.Logger;

import com.revature.strings.checkers.IsNumericChecker;

/**
 * Takes user input and checks if it is valid input for menu selections
 * 
 * @author Bobby McGetrick
 *
 */
public class InputValidator {
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	/**
	 * Construct a new InputValidator
	 */
	public InputValidator() {
		super();
		log.trace("Creating new InputValidator");
		log.trace("Called super constructor - Object");
		log.trace("New WithdarwalScree created");
		log.trace("Prompting InputValidator");
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve InputValidator.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		return log;
	}

	/**
	 * Setting TransactionScreen.log to a given Logger
	 * @return Logger log
	 */
	public static void setLog(Logger log) {
		InputValidator.log = log;
	}
	
	/************************************************************************************
	 * Methods
	 ************************************************************************************/
	/**
	 * Checks if user input was valid - is a number and within range of account choices
	 * 
	 * @param String input
	 * @param int rangeMax
	 * 
	 * @return int
	 */
	public int validAccountSelection(String input, int rangeMax) {
		log.trace("Calling method to check if user input is a number");
		if (!isANumber(input)) {
			log.trace("Returning new -1");
			return -1;
		}
		
		log.trace("Convert String input to an Integer accountId");
		Integer accountIndex = Integer.parseInt(input);
		log.trace("Checking if user input was within displayed choices");
		if (accountIndex < 1 || accountIndex > rangeMax) {
			log.trace("User input was invalid - outside the range of choices");
			System.out.println("Sorry, that choice does not match any of your accounts, please try again");
			log.trace("Returning new -1");
			return -1;
		}
		
		log.trace("User input is valid, returning accountIdex");
		return accountIndex;
	}

	/**
	 * Checks if input String is a number
	 * if it isn't returns false, otherwise returns true
	 * 
	 * @param String input
	 * 
	 * @return boolean
	 */
	public boolean isANumber(String input) {
		log.trace("Checking if user input is a nubmer or is empty");
		if (!IsNumericChecker.isNumeric(input)) {
			log.trace("User input was invalid - not a number or empty");
			System.out.println("Please enter a number to select one of your accounts");
			log.trace("Returning new false");
			return false;
		}
		log.debug("User input is a number, returning true");
		return true;
	}

}
