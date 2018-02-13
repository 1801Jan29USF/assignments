package com.revature.screens;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.AccountName;
import com.revature.beans.Transaction;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountNameDAO;
import com.revature.dao.TransactionDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.Screen;
import com.revature.util.singleton.input.AccountSelector;
import com.revature.util.singleton.input.ScannerSingleton;

/**
 * History screen displayed to user for banking application
 * 
 * User selects all accounts or a single account if they want
 * to view the transaction history of
 * 
 * @author Bobby McGetrick
 *
 */
public class HistoryScreen implements Screen {
	
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
	 * Create new HistoryScreen
	 */
	public HistoryScreen() {
		super();
		log.trace("Creating new HistoryScreen");
		log.trace("Called super constructor - Object");
		log.trace("New WithdarwalScree created");
		log.trace("Prompting HistoryScreen");
		prompt();
	}
	
	/**
	 * Create new HistoryScreen with predefined fields
	 * 
	 * @param int userId
	 */
	public HistoryScreen(int userId) {
		super();
		log.trace("Creating new HistoryScreen");
		log.trace("Called super constructor - Object");
		log.trace("Setting userId = " + userId);
		this.userId = userId;
		log.trace("New WithdarwalScree created");
		log.trace("Prompting HistoryScreen");
		prompt();
	}

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate HistoryScreen hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating HistoryScreen hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scan == null) ? 0 : scan.hashCode());
		result = prime * result + userId;
		log.trace("Returning Account hash code");
		return result;
	}

	/**
	 * Check if HistoryScreen is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if HistoryScreen is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryScreen other = (HistoryScreen) obj;
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
	 * Retrieve HistoryScreen.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		return log;
	}

	/**
	 * Setting HistoryScreen.log to a given Logger
	 * @return Logger log
	 */
	public static void setLog(Logger log) {
		HistoryScreen.log = log;
	}

	/**
	 * Retrieve HistoryScreen.ScannerSingleton
	 * @return ScannerSingleton scan
	 */
	public ScannerSingleton getScan() {
		return scan;
	}

	/**
	 * Setting HistoryScreen.scan to a given ScannerSingleton
	 */
	public void setScan(ScannerSingleton scan) {
		this.scan = scan;
	}

	/**
	 * Retrieve HistoryScreen.userId
	 * @return int userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Setting HistoryScreen.userId to a given integer
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
	 * Displays banking application's History menu to the user
	 * User can input through the console an account choice
	 * whether they would like to view the all transaction history
	 * associated with their user id or the transaction history
	 * of a single account that they are an owner of
	 * 
	 * Display new Screen based on user input
	 * 
	 * @return Screen
	 */
	@Override
	public Screen prompt() {
		log.trace("Displaynig History Screen");
		
		System.out.println("-------------------------------------------------------------------------------------------------");
		
		System.out.println("Please enter the number of the option you would like to select");
		System.out.println("1 to view all of your transaction history");
		System.out.println("2 to view the transaction history of a single account");
		log.trace("Getting user input");
		switch (scan.nextLine()) {
		
		case "1":
			log.debug("User selected to view all transaction history");
			log.trace("Calling method to retreive transaction history");
			viewHistory(0);
			log.trace("Returning new MainMenu");
			return new MainMenu(userId);
			
		case "2":
			log.debug("User selected to view transaction history of a single account");
			log.trace("Creating new AccountSelector");
			AccountSelector accountSelector = new AccountSelector();
			log.trace("Calling methods to select an account and then retrieve transaction history");
			Account account = accountSelector.displayAndSelectAccount(userId);
			if (account == null) {
				System.out.println("sorry that account choice was not valid, please try again");
				return new HistoryScreen(userId);
			}
			viewHistory(account.getId());
			log.trace("Returning new MainMenu");
			return new MainMenu(userId);

		default:
			log.debug("User entered invalid input");
			System.out.println("Invalid input, please try again");
			log.trace("Returning HistoryScreen");
			return new HistoryScreen(userId);
		}
	}

	/************************************************************************************
	 * Methods
	 ************************************************************************************/	
	/**
	 * View the history of a given account or all acconts owned by a user
	 * 
	 * @param int accountId
	 */
	public void viewHistory(int accountId) {
		log.trace("Creating new empty List of Transactions");
		List<Transaction> transactionList;
		log.trace("Check if user wanted to select all accounts, or just a single account");
		if (accountId < 1) {
			log.debug("User chose to veiw all account's history");
			
			log.trace("Creating new TransactionDAO");
			TransactionDAO transactionDAO = new TransactionDAO();
			
			log.trace("Calling method to retreive full transaction history of user id " + userId);
			transactionList = transactionDAO.getAllByUserId(userId);
		} else {
			System.out.println("Please enter the number of the account that you would like to view the transaction history of:");
			log.debug("User chose to veiw a single account's history");
			
			log.trace("Creating new TransactionDAO");
			TransactionDAO transactionDAO = new TransactionDAO();
			
			log.trace("Calling method to retreive transaction history of account with user id " + userId + " and account id" + accountId);
			transactionList = transactionDAO.getAllByAccountId(accountId);
		}
		
		log.trace("Calling method to format and display transaction history");
		display(transactionList);
	}

	/**
	 * Takes a List of Transactions then formats and displays them to the user
	 * 
	 * @param List<Transaction> transactionList
	 */
	public void display(List<Transaction> transactionList) {
		log.trace("Iterate through list of transaction and display the transaction");
		for (Transaction transaction : transactionList) {
			log.trace("Creating new Strings to store transaction type");
			String transactionType;
			String toOrFrom;
			log.trace("Storing transaction amount into a foat");
			float amount = transaction.getAmountDeposited();
			
			log.trace("Cheking if transaciton was a withdrawal or a deposit");
			if (amount < 0) {
				log.trace("Transaction was a withdrawal");
				log.trace("Negating transaction amount");
				amount = -amount;
				log.trace("Setting transaction type to 'Withdrew'");
				transactionType = "Withdrew";
				toOrFrom = "from";
			} else {
				log.trace("Transaction was a deposit");
				log.trace("Setting transaction type to 'Deposited'");
				transactionType = "Deposited";
				toOrFrom = "into";
			}
			
			log.trace("Creating new DateTimeFormatter");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			log.trace("Getting account name");
			log.trace("Creating new AccountDAO");
			DAO<Account> accountDAO = new AccountDAO();
			log.trace("Creating new Account");
			Account account = accountDAO.get(transaction.getAccountId());
			log.trace("Creating new AccountNameDAO");
			DAO<AccountName> accountNameDAO = new AccountNameDAO();
			log.trace("Creating new AccountName");
			String accountName = accountNameDAO.get(account.getAccountNameId()).getAccountName();
					
			log.trace("Displaying transaciton");
			System.out.println(transactionType + " $" + amount + " " + toOrFrom + " " + accountName + " on " + transaction.getDate().format(formatter));
		}
	}

}
