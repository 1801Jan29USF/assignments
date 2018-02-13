package com.revature.screens;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.dao.AccountDAO;
import com.revature.dao.TransactionDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.MultiResultDAO;
import com.revature.interfaces.Screen;
import com.revature.util.singleton.input.InputValidator;
import com.revature.util.singleton.input.ScannerSingleton;
import com.revature.util.singleton.output.DisplayResultSetRows;

/**
 * Transaction screen displayed to user for banking application
 * 
 * User selects an account if they want to deposit or withdraw
 * and an amount of the transaction
 * Double checks if user wants to make that Transaction
 * 
 * Checks if withdrawal amount is valid, a number > 0 and that
 * does not put the selected accounts balance < 0
 * 
 * Checks if deposit amount is valid, a number > 0
 * 
 * @author Bobby McGetrick
 *
 */
public class TransactionScreen implements Screen {

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
	 * Create new TransactionScreen
	 */
	public TransactionScreen() {
		super();
		log.trace("Creating new TransactionScreen");
		log.trace("Called super constructor - Object");
		log.trace("New WithdarwalScree created");
		log.trace("Prompting TransactionScreen");
		prompt();
	}
	
	/**
	 * Create new TransactionScreen with predefined fields
	 * 
	 * @param int userId
	 */
	public TransactionScreen(int userId) {
		super();
		log.trace("Creating new TransactionScreen");
		log.trace("Called super constructor - Object");
		log.trace("Setting userId = " + userId);
		this.userId = userId;
		log.trace("New WithdarwalScree created");
		log.trace("Prompting TransactionScreen");
		prompt();
	}
	
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate TransactionScreen hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating TransactionScreen hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scan == null) ? 0 : scan.hashCode());
		result = prime * result + userId;
		log.trace("Returning Account hash code");
		return result;
	}

	/**
	 * Check if TransactionScreen is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if TransactionScreen is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionScreen other = (TransactionScreen) obj;
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
	 * Retrieve TransactionScreen.log
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
		TransactionScreen.log = log;
	}

	/**
	 * Retrieve TransactionScreen.ScannerSingleton
	 * @return ScannerSingleton scan
	 */
	public ScannerSingleton getScan() {
		return scan;
	}

	/**
	 * Setting TransactionScreen.scan to a given ScannerSingleton
	 */
	public void setScan(ScannerSingleton scan) {
		this.scan = scan;
	}

	/**
	 * Retrieve TransactionScreen.userId
	 * @return int userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Setting TransactionScreen.userId to a given integer
	 * @param int userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/************************************************************************************
	 * Overrides
	 ************************************************************************************/
	/**
	 * Overrides Screen.prompt() from Screen interface
	 * 
	 * Displays banking application's Transaction menu to the user
	 * User can input through the console an account choice
	 * whether they would like to withdraw r deposit
	 * and how much they would like to withdraw/deposit
	 * 
	 * Display new Screen based on user input
	 * 
	 * @return Screen
	 */
	@Override
	public Screen prompt() {
		log.trace("Displayiing Transaction screen");
		System.out.println("-------------------------------------------------------------------------------------------------");
		log.trace("Creating new DisplayReultSetRows");
		DisplayResultSetRows drsr = new DisplayResultSetRows();
		log.trace("Creating a List of Accounst associated with user id " + userId);
		log.trace("Calling method to display all accounts and their balances associated with user id " + userId);
		List<Account> accountList = drsr.displayAccountsAndBalances(userId);
		
		System.out.println("Enter the number of the account you would like to perform a transaction with:");
		log.debug("Getting user input");
		String input = scan.nextLine();
		
		log.trace("Creating new InputValidator");
		InputValidator inputValidator = new InputValidator();
		if (inputValidator.validAccountSelection(input, accountList.size()) == -1) {
			log.trace("Returning new TransactionScreen");
			return new TransactionScreen(userId);
		}
		
		log.trace("Converting input String to an Integer index");
		Integer index = Integer.parseInt(input) - 1;
		
		log.trace("Account selection was valid, prompting for transaction type selection");
		
		System.out.println("Would you like to withdraw or deposit?");
		System.out.println("1 to withdraw");
		System.out.println("2 to deposit");
		System.out.println("3 to cancel");
		log.trace("Getting user input");
		input = scan.nextLine();
		
		log.trace("Calling method to check if user input is a number");
		
		if ((Integer.parseInt(input) != 1 && Integer.parseInt(input) != 2 && Integer.parseInt(input) != 3) || !inputValidator.isANumber(input)) {
			log.trace("Returning new TransactionScreen");
			System.out.println("Sorry, that choice was not vali, please try again");
			return new TransactionScreen(userId);
		}
		log.debug("Transaction type selection was valid");
		
		if (Integer.parseInt(input) == 3) {
			log.debug("User chose to cancel transaction, returning new MainMenu");
			System.out.println("Canceling transaction");
			return new MainMenu(userId);
		}
		
		log.trace("Converting input to an Interger transactionType");
		Integer transactionType = Integer.parseInt(input);
		
		log.trace("Transaction type selection was valid");
		if (transactionType == 1) {
			log.trace("Prompting for amount to witdraw");
			System.out.println("Enter the amount you would like to withdraw:");
		} else {
			log.trace("Prompting for amount to deposit");
			System.out.println("Enter the amount you would like to deposit:");
		}
		input = scan.nextLine();
		log.debug("User input an aount of: " + input);
		log.trace("Calling method to make the transaction for " + input);
		makeTransaction(input, accountList.get(index), transactionType);
		
		return new MainMenu(userId);
	}

	/************************************************************************************
	 * Methods
	 ************************************************************************************/
	/**
	 * Ensures amount for transaction is numeric the uses an AccountDAO
	 * to update the selected account and a TransactionDAO to submit
	 * the new transaction to the transactions table of the database
	 * 
	 * @param input
	 * @param account
	 * @param transactionType
	 * 
	 * @return Screen
	 */
	private Screen makeTransaction(String input, Account account, int transactionType) {
		log.trace("Creating new InputValidator");
		InputValidator inputValidator = new InputValidator();
		log.trace("Calling method to check if user input is a number");		
		if (!inputValidator.isANumber(input)) {
			log.trace("Returning new TransactionScreen");
			return new TransactionScreen(userId);
		}
		
		log.trace("Converting input String to an Integer amount");
		Float amount = Float.parseFloat(input);
		
		log.trace("Ensuring user cannot over draw and did not enter a negative amount");
		if (amount <= 0) {
			log.debug("User input is invalid: amount entered was negative or zero");
			System.out.println("Amount entered was negative value or zero, no transaction was made, please try again");
			log.trace("Returing new TransactionScreen");
			return new TransactionScreen(userId);
		} else if (transactionType == 1 && amount > account.getBalance()) {
			log.debug("User input is invalid: withdrawal amount exceeds balance");
			System.out.println("Amount entered was greater than your current balance, no withdrawal was made, please try again");
			log.trace("Returing new TransactionScreen");
			return new TransactionScreen(userId);
		} else {
			log.debug("User input is valid, creating transaction");
			
			log.trace("Changing balance in account with id: " + account.getId());
			log.trace("chekcing if amount needs to be negated for a withdrawal");
			if (transactionType == 1) {
				log.trace("Amount needs to be negated for a withdrawal, negating submitted amount");
				amount = -amount;
			}
			log.trace("Updating account balance");
			account.setBalance(account.getBalance() + amount);
			
			log.trace("Creating new AccountDAO");
			DAO<Account> accountDAO = new AccountDAO();
			log.trace("Calling method to update account in the database");
			accountDAO.update(account);
			
			log.trace("Creating new Transaction");
			Transaction newTransaction = new Transaction(userId, account.getId(), amount);
			log.trace("Creating new TransactionDAO");
			MultiResultDAO<Transaction> transactionDAO = new TransactionDAO();
			log.trace("Calling method to insert the new transaction into the transaction table of the database");
			transactionDAO.create(newTransaction);
			
			System.out.println("Transaction sucessful, press ENTER to return to the main menu");
			log.trace("Getting user input");
			scan.nextLine();
			log.debug("User input = ENTER");
			log.trace("Returning MainMenu");
			return new MainMenu(userId);
		}
	}

}
