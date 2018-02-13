package com.revature.util.singleton.input;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.util.singleton.output.DisplayResultSetRows;

public class AccountSelector {

	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	/**
	 * Construct a new AccountSelector
	 */
	public AccountSelector() {
		super();
		log.trace("Creating new AccountSelector");
		log.trace("Called super constructor - Object");
		log.trace("New WithdarwalScree created");
		log.trace("Prompting AccountSelector");
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve AccountSelector.log
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
		AccountSelector.log = log;
	}
	
	/************************************************************************************
	 * Methods
	 ************************************************************************************/
	/**
	 * Displays user owned accounts and prompts user to select one
	 * 
	 * @param int userId
	 * 
	 * @return Account
	 */
	public Account displayAndSelectAccount(int userId) {
		log.trace("Creating new DisplayResultSetRows");
		DisplayResultSetRows drsr = new DisplayResultSetRows();
		log.trace("Creating new list of accounts belong to the current user");
		List<Account> accountList = drsr.displayAccountsAndBalances(userId);
		log.trace("Getting the number of accounts owned by the current user");
		int maxRange = accountList.size();
		log.debug("Getting user input");
		String input = scan.nextLine();
		
		log.trace("Creating new InputValidator");
		InputValidator inputValidator = new InputValidator();
		if (inputValidator.validAccountSelection(input, maxRange) == -1) {
			log.trace("Returning new TransactionScreen");
			System.out.println("That choice does not match any accounts listed above, aborting");
			return null;
		}
		
		log.debug("User input was valid");
		log.trace("Converting input String to an interger index");
		Integer index = Integer.parseInt(input) - 1;
		log.trace("Creating new Account");
		return new Account(accountList.get(index).getId(), accountList.get(index).getAccountNameId(), accountList.get(index).getBalance());
		
	}
	
}
