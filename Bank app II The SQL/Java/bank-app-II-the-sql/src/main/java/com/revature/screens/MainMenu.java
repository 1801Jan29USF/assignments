package com.revature.screens;

import org.apache.log4j.Logger;

import com.revature.interfaces.Screen;
import com.revature.util.singleton.input.ScannerSingleton;

/**
 * Main Menu screen displayed to user for banking application
 * 
 * @author Bobby McGetrick
 *
 */
public class MainMenu implements Screen {
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	private int userId;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new OpenScreen
	 */
	public MainMenu() {
		super();
		log.trace("Constructing new MainMenu");
		log.trace("Called super constructor - Object");
		log.trace("New MainMenu created");
		log.trace("Prompting MainMenu");
		prompt();
	}
	
	public MainMenu(int userId) {
		super();
		log.info("Constructing new MainMenu");
		log.info("Setting userId = " + userId);
		this.setUserId(userId);
		log.trace("New MainMenuScreen created");
		log.info("Prompting MainMenu");
		prompt();
	}
	
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate MainMenu hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating MainMenu hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scan == null) ? 0 : scan.hashCode());
		result = prime * result + userId;
		log.trace("Returning MainMenu hash code");
		return result;
	}

	/**
	 * Check if MainMenu is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if MainMenu is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MainMenu other = (MainMenu) obj;
		if (scan == null) {
			if (other.scan != null)
				return false;
		} else if (!scan.equals(other.scan))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve MainMenu.userId
	 * @return int userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Setting MainMenu.userId to a given integer
	 * @param int userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
		
	/**
	 * Retrieve MainMenu.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		log.trace("Returning Logger: " + log);
		return log;
	}

	/**
	 * Retrieve MainMenu.ScannerSingleton
	 * @return ScannerSingleton scan
	 */
	public ScannerSingleton getScan() {
		log.trace("Returning ScannerSingleton = " + scan);
		return scan;
	}
	
	/************************************************************************************
	 * Overrides
	 ************************************************************************************/
	/**
	 * Overrides Screen.prompt() from Screen interface
	 * 
	 * Displays banking application's main menu to the user
	 * User can input through the console to choose their choice to
	 * make a transaction, logout, or view their transaction history
	 * 
	 * Display new Screen based on user input
	 * 
	 * TODO Give the user the option to create new accounts
	 * 
	 * @return Screen
	 */
	@Override
	public Screen prompt() {
		log.info("Displaying MainMenu Screen");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("Please enter the number of the option you would like to select");
		System.out.println("1 to display all balances");
		System.out.println("2 to manage accounts");
		System.out.println("3 to make a transaction");
		System.out.println("4 to view transaction history");
		System.out.println("5 to logout");
		log.trace("Getting user input");
		switch (scan.nextLine()) {
		case "1":
			log.debug("User selected to display all account balances, returning new BalanceScreen");
			return new BalanceScreen(userId);
			
		case "2":
			log.debug("User selected to manage accounts");
			return new AccountScreen(userId);
		case "3":
			log.debug("User selected to make a transaction");
			return new TransactionScreen(userId);
		case "4":
			log.debug("User slected to view transaction history");
			return new HistoryScreen(userId);
		case "5":
			log.debug("User selected to log out");
			System.out.println("Thanks for visting!");
			return new OpenScreen();
		default:
			log.debug("User entered invalid input");
			System.out.println("Invalid input, please try again");
			log.info("Returning new MainMenu");
			return new MainMenu(userId);
		}
	}

}
