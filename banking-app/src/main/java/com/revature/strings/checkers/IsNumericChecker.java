package com.revature.strings.checkers;

import org.apache.log4j.Logger;

public class IsNumericChecker {
	
	private static Logger log = Logger.getRootLogger();
	
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
