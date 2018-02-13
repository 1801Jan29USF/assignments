package com.revature.screens;

import org.apache.log4j.Logger;

import com.revature.interfaces.Screen;
import com.revature.util.singleton.input.ScannerSingleton;

/**
 * Initial screen displayed to user for banking application
 * 
 * @author Bobby McGetrick
 *
 */
public class OpenScreen implements Screen {
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private static ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new OpenScreen
	 */
	public OpenScreen() {
		super();
		log.trace("Constructing new OpenScreen");
		log.trace("Called super constructor - Object");
		log.trace("New OpenScreen created");
		log.trace("Prompting OpenScreen");
		prompt();
	}	
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve OpenScreen.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		log.trace("Returning Logger: " + log);
		return log;
	}

	/**
	 * Retrieve OpenScreen.ScannerSingleton
	 * @return ScannerSingleton scan
	 */
	public ScannerSingleton getScan() {
		log.trace("Returning ScannerSingleton = " + scan);
		return scan;
	}
	
	/************************************************************************************
	 * toString()
	 ************************************************************************************/
	/**
	 * Convert OpenScreen to a String listing OpenScreen's values
	 */
	public String toString() {
		log.trace("Converting OpenScreen to a string");
		return "OpenScreen ["
				+ "log= " + log
				+ ", scan=" + scan + "]";
	}
	
	/************************************************************************************
	 * Overrides
	 ************************************************************************************/
	/**
	 * Overrides Screen.prompt() from Screen interface
	 * 
	 * Displays banking application's initial menu to the user
	 * User can input through the console their choice to
	 * login, register a new user, or quit and close the application
	 * 
	 * Displays new Screen based on user input
	 * @return Screen
	 */
	@Override
	public Screen prompt() {
		log.trace("Displaying OpenScreen menu");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("Welcome to Revature Revnue!");
		System.out.println("Register today to get a free $100 in your first account with us");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("Please enter the number of the option you would like to select");
		System.out.println("1 to login");
		System.out.println("2 to register");
		System.out.println("3 to quit");
		log.trace("Getting user input");
		switch (scan.nextLine()) {
		case "1":
			log.debug("User selected to login");
			log.trace("Returning LoginScreen");
			return new LoginScreen();

		case "2":
			log.debug("User selected to register");
			log.trace("Returning RegistrationScreen");
			return new RegistrationScreen();

		case "3":
			log.debug("User selected to quit");
			System.out.println("Good bye!");
			log.trace("Exiting application");
			System.exit(0);
			break;

		default:
			log.debug("User entered invalid input");
			System.out.println("Invalid input, please try again");
			log.trace("Returning OpenScreen");
			return new OpenScreen();
		}
		log.warn("Switch did not handle user input correctly");
		return null;
	}

}
