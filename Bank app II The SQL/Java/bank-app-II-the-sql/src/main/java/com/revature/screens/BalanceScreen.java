package com.revature.screens;

import org.apache.log4j.Logger;

import com.revature.interfaces.Screen;
import com.revature.util.singleton.input.ScannerSingleton;
import com.revature.util.singleton.output.DisplayResultSetRows;

/**
 * Balance screen displayed to user for banking application
 * 
 * Displays Account name and Balance of either one account
 * or all accounts that belong to the User currently logged through
 * a request to the database
 * 
 * @author Bobby McGetrick
 *
 */
public class BalanceScreen implements Screen {
	
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
	 * Create new RegiatrationScreen
	 */
	public BalanceScreen() {
		super();
		log.trace("Constructing new BalanceScreen");
		log.trace("Called super constructor - Object");
		log.trace("New BalanceScreen created");
		log.trace("Prompting BalanceScreen");
		prompt();
	}
	
	/**
	 * Create new RegiatrationScreen
	 */
	public BalanceScreen(int userId) {
		super();
		log.trace("Constructing new BalanceScreen");
		log.trace("Called super constructor - Object");
		log.trace("Setting BalanceScreen.userId = " + userId);
		this.userId = userId;
		log.trace("New BalanceScreen created");
		log.trace("Prompting BalanceScreen");
		prompt();
	}
	
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate BalanceScreen hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating BalanceScreen hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scan == null) ? 0 : scan.hashCode());
		result = prime * result + userId;
		log.trace("Returning BalanceScreen hash code");
		return result;
	}

	/**
	 * Check if BalanceScreen is equivalent to another Object
	 * 
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if BalanceScreen is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BalanceScreen other = (BalanceScreen) obj;
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
	 * Retrieve BalanceScreen.userId
	 * @return int userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Setting BalanceScreen.userId to a given integer
	 * @param int userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * Retrieve BalanceScreen.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		log.trace("Returning Logger: " + log);
		return log;
	}

	/**
	 * Retrieve BalanceScreen.ScannerSingleton
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
	 * Displays banking application's balance Screen to the user
	 * Shows name and balance of all accounts that belong to the user
	 * 
	 * @return Screen
	 */
	@Override
	public Screen prompt() {
		log.trace("Creating new DisplayReultSetRows");
		System.out.println("-------------------------------------------------------------------------------------------------");
		DisplayResultSetRows drsr = new DisplayResultSetRows();
		log.trace("Calling method to display all accounts and their balances associated with user id " + userId);
		drsr.displayAccountsAndBalances(userId);
		
		log.trace("All accounts and their balances for user id " + userId + " have been dislayed, returning new MainMenu");
		return new MainMenu(userId);
	}
	
}
