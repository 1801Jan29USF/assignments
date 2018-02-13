package com.revature.screens;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.AccountName;
import com.revature.beans.User;
import com.revature.beans.UserToAccount;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountNameDAO;
import com.revature.dao.UserDAO;
import com.revature.dao.UserToAccountDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.JunctionDAO;
import com.revature.interfaces.Screen;
import com.revature.strings.checkers.IsNumericChecker;
import com.revature.util.singleton.input.AccountSelector;
import com.revature.util.singleton.input.InputValidator;
import com.revature.util.singleton.input.ScannerSingleton;

/**
 * Account screen displayed to user for banking application
 * 
 * Prompts the user to make either create a new account, delete an account
 * and another user to an account, or rename an account in the database
 * 
 * @author Bobby McGetrick
 *
 */
public class AccountScreen implements Screen {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	private int userId;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new AccountScreen
	 */
	public AccountScreen() {
		super();
		log.trace("Constructing new AccountScreen");
		log.trace("Called super constructor - Object");
		log.trace("New AccountScreen created");
		log.trace("Prompting AccountScreen");
		prompt();
	}

	/**
	 * Create a new AccountScreen with predefined values
	 * 
	 * @param int userId
	 */
	public AccountScreen(int userId) {
		super();
		log.trace("Constructing new AccountScreen");
		log.trace("Called super constructor - Object");
		log.trace("Setting user id = " + userId);
		this.userId = userId;
		log.trace("New AccountScreen created");
		log.trace("Prompting AccountScreen");
		prompt();
	}

	/************************************************************************************
	 * hashCode() & equals()
	 ************************************************************************************/
	/**
	 * Generate AccountScreen hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating AccountScreen hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scan == null) ? 0 : scan.hashCode());
		result = prime * result + userId;
		log.trace("Returning AccountScreen hash code");
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if AccountScreen is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountScreen other = (AccountScreen) obj;
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
	 * Retrieve AccountScreen.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		log.trace("Returning Logger: " + log);
		return log;
	}

	/**
	 * Setting AccountScreen.log to a given Logger
	 * @return ScannerSingleton scan
	 */
	public static void setLog(Logger log) {
		log.trace("Setting Logger = " + log);
		AccountScreen.log = log;
	}
	
	/**
	 * Retrieve AccountScreen.ScannerSingleton
	 * @return ScannerSingleton scan
	 */
	public ScannerSingleton getScan() {
		log.trace("Returning ScannerSingleton = " + scan);
		return scan;
	}

	/**
	 * Setting AccountScreen.scan to a given SannerSingleton
	 * @return ScannerSingleton scan
	 */
	public void setScan(ScannerSingleton scan) {
		log.trace("Setting ScannerSingleton = " + scan);
		this.scan = scan;
	}

	/**
	 * Retrieve AccountScreen.userId
	 * @return int userId
	 */
	public int getUserId() {
		log.trace("Returning user id: " + userId);
		return userId;
	}

	/**
	 * Setting AccountScreen.userId to a given integer
	 * @return int userId
	 */
	public void setUserId(int userId) {
		log.trace("Setting user id = " + userId);
		this.userId = userId;
	}

	/************************************************************************************
	 * Overrides
	 ************************************************************************************/
	/**
	 * Overrides Screen.prompt() from the Screen interface
	 * 
	 * Displays banking application's account menu to the user
	 * User can input through the console to choice whether to add an account,
	 * delete an account, change an account's name, or share an account with another user
	 * 
	 * Displays new Screen based on user input
	 * 
	 * @return Screen
	 */
	@Override
	public Screen prompt() {
		log.trace("Displaying AccountScreen menu");
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("Please enter the number of the option you would like to select");
		System.out.println("1 to add a new account");
		System.out.println("2 to rename an account");
		System.out.println("3 to delete an account");
		System.out.println("4 to share an account with another user");
		System.out.println("5 to transfer funds between accounts");
		System.out.println("6 to return to the main menu");
		log.trace("Getting user input");
		
		switch (scan.nextLine()) {
		case "1":
			log.debug("User selected to add a new account");
			log.trace("Calling method to add a new account");
			addAccount();
			log.trace("New account created, returning new AccountScreen");
			return new AccountScreen(userId);
			
		case "2":
			log.debug("User selected to rename an account");
			log.trace("Calling method to rename an account");
			renameAccount();
			log.trace("Account renamed, returning new AccountScreen");
			return new AccountScreen(userId);
		
		case "3":
			log.debug("User selected to delete an account");
			log.trace("Calling method to delete an account");
			deleteAccount();
			log.trace("Deletion complete or aborted, returning new AccountScreen");
			return new AccountScreen(userId);
			
		case "4":
			log.debug("User selected to share and account");
			log.trace("Calling method to share an account");
			shareAccount();
			log.trace("Account sharing complete or aborted, returning new AcountScreen");
			return new AccountScreen();
			
		case "5":
			log.debug("User selected to transfer funds");
			log.trace("Calling method to transfer funds");
			transfer();
			log.trace("Tranfer complete or aborted, returning new AcountScreen");
			return new AccountScreen(userId);
			
		case "6":
			log.debug("User selected to return to the MainMenu");
			log.trace("Returning new MainMenu");
			return new MainMenu(userId);

		default:
			log.debug("User entered invalid input");
			System.out.println("Invalid input, please try again");
			log.info("Returning new AccountScreen");
			return new AccountScreen(userId);
		}
	}
	
	/************************************************************************************
	 * Methods
	 ************************************************************************************/
	/**
	 * Prompts a user for the name of the new account then inserts it
	 * and a new account into the database
	 * 
	 * @return int
	 */
	private int addAccount() {
		log.trace("Calling method to create a new account name, if the name already exists a new account will NOT be created");
				
		log.trace("Creating new Account");
		int accountNameId = createAccountName();
		Account newAccount = new Account(accountNameId, 0.00f);
		log.trace("Creating new AccountDAO");
		DAO<Account> accountDAO = new AccountDAO();
		log.trace("Calling method to display accounts and their balance");
		log.trace("Inserting new Account to the accounts table in the database");
		int newAccountId = accountDAO.create(newAccount);	
		
		log.trace("Creating new UserToAccount");
		UserToAccount newAcUserTocount = new UserToAccount(userId, newAccountId);
		log.trace("Creating new UserToAccountDAO");
		DAO<UserToAccount> userToAccountDAO = new UserToAccountDAO();
		log.trace("Inserting new UserToAccount to the user_to_account table in the database");
		userToAccountDAO.create(newAcUserTocount);
		
		log.trace("New entried inserted into the database, returning new account id");
		return newAccountId;
			
	}

	/**
	 * Prompts the user for a new account name then inserts it into
	 * the database if it does not already exist and updates the
	 * account name id of the corresponding account if necessary
	 */
	public Screen renameAccount() {
		log.trace("Creating new AccountSelector");
		AccountSelector accountSelector = new AccountSelector();
		log.trace("Calling method to display and select an account");
		Account account = accountSelector.displayAndSelectAccount(userId);
		account.setaccountNameId(createAccountName());
		log.trace("Creating new AccountDAO");
		DAO<Account> accountDAO = new AccountDAO();
		log.trace("Updating the account name id of the account in the database");
		accountDAO.update(account);
		log.trace("Returning new AccountScreen");
		return new AccountScreen(userId);
	}
	
	/**
	 * Prompts the user for an account name and then creates it and
	 * returns the new id if it does not already exist,
	 * else it returns the id of the existing account name
	 * 
	 * @return int
	 */
	public int createAccountName() {
		System.out.println("Please enter the new name of the account:");
		log.trace("Getitng user input");
		String input = scan.nextLine();
		
		log.trace("Creating new AccountName");
		AccountName newAccountName = new AccountName(input);
		log.trace("Creating new AccountNameDAO");
		DAO<AccountName> accountNameDAO = new AccountNameDAO();
		try {
			newAccountName.getAccountName().equals(accountNameDAO.get(input).getAccountName());
			log.trace("Given account name already exists, returning that account name id");
			return accountNameDAO.get(input).getId();
		} catch (NullPointerException e) {
			log.warn("Given account name does not exist, creating a new acount name with the user input");
		}
		log.trace("Account name is new to the database, inserting new account name to the account names table in the database");
		int id = accountNameDAO.create(newAccountName);
		return id;	
	}
	
	public Screen deleteAccount() {
		System.out.println("WARNING: Deleting an account is final are you sure you want to delete one?");
		System.out.println("1 NO");
		System.out.println("2 YES");
		log.trace("Getting user input");
		String input  = scan.nextLine();
		
		if (!IsNumericChecker.isNumeric(input) || (Integer.parseInt(input) != 1 && Integer.parseInt(input) != 2)) {
			log.debug("User input was invalid - not a number or not in range of choices, calling method to delete an account");
			System.out.println("Sorry, that choice was invalid, please try again");
			return new AccountScreen(userId);
		}
		
		if (input.equals("1")) {
			log.debug("User chose not to delete any accounts, aborting deletion process - returning new AccountScreen");
			return new AccountScreen(userId);
		}
		
		System.out.println("Please enter the name of the account you would like to delete or anything else to abort:");
		log.trace("Getting user input");
		input = scan.nextLine();
		
		log.trace("Creating new AccountNameDAO");
		DAO<AccountName> accountNameDAO = new AccountNameDAO();
		log.trace("Getting id of submitted account name");
		int accountNameId = accountNameDAO.get(input).getId();
		
		log.trace("Creating new AccountDAO");
		DAO<Account> accountDAO = new AccountDAO(userId);
		
		log.trace("Creating new UserToAccountDAO");
		JunctionDAO<UserToAccount> userToAccountDAO = new UserToAccountDAO();
		
		log.trace("Checking if account name exits in the database");
		if (accountNameId < 1) {
			log.trace("Account name does not exist in the database, calling method to delte an account");
			System.out.println("Input was does not match any owned table names, aborting deletion process");
			return new AccountScreen(userId);
		}
		
		log.trace("Checking if user has ownership of this account");
		if (userId != userToAccountDAO.getByCompositeKey(userId, accountDAO.get(input).getId()).getUserId()) {
			log.debug("User does not have ownership of this account, calling method to delete an account");
			System.out.println("Sorry, this account does not belong to you, please try again");
			return new AccountScreen(userId);
		}
		
		log.trace("Account exists and belongs to the user");
		System.out.println("Pease type the following exactly as you see it to finalize the deletion of your selected accounnt or anything else to abort");
		String deleteCheck = "dElEtE aCcOuNt";
		log.trace("Saving previous user input");
		String accountName = input;
		System.out.println(deleteCheck);
		input  = scan.nextLine();
		if (!input.equals(deleteCheck)) {
			log.debug("USer input was invalid - did not match the deltion check, calling method to delete an account");
			System.out.println("Input did not match, restarting deletion process");
			return new AccountScreen(userId);
		}
		log.trace("Delete check matched user input");
		
		log.trace("Checking if account has a 0 balance");
		if (accountDAO.get(accountName).getBalance() > 0) {
			log.trace("Account has a balance > then $0, aborting deletion process, calling method to delete an account");
			System.out.println("This account has a balance greater than $0, it cannot be deleted yet");
			return new AccountScreen(userId);
		}
		
		log.trace("All checks passed, deleting account");
		accountDAO.delete(accountDAO.get(accountName));
		System.out.println("Account deleted");
		
		return new AccountScreen(userId);
	}
	
	/**
	 * Prompts user to select an account to share and then enter
	 * a user name to share it with
	 */
	public Screen shareAccount() {
		System.out.println("Select the account you would like to share with another user");
		
		log.trace("Creating new AccountSelector");
		AccountSelector accountSelector = new AccountSelector();
		log.trace("Calling method to display and select an account");
		Account account = accountSelector.displayAndSelectAccount(userId);
		
		System.out.println("Please enter the user name to add to this account:");
		log.trace("Getting user input");
		String input = scan.nextLine();
		log.trace("Checking is user input was empty");
		if (input.isEmpty()) {
			log.debug("User input was invali - empty Srting");
			System.out.println("Sorry, you entered an empty user name, please try again");
			log.trace("Calling method to share an account");
			shareAccount();
			log.trace("Returning new AccountScreen");
			return new AccountScreen(userId);
		}
		log.debug("User input was not empty");
		
		log.trace("Creating new UserDAO");
		DAO<User> userDAO = new UserDAO();
		log.trace("Finding user in database with the user subitted user name " + input);
		User user = userDAO.get(input);
		
		log.trace("Checking if user exists");
		if (user == null) {
			log.debug("User with user name " + input + " does not exist");
			System.out.println("Sorry, that user is not a part of our bank, please try again");
			log.trace("Calling method to share an account");
			log.trace("Returning new AccountScreen");
			return new AccountScreen(userId);
		}
		log.debug("User with user name " + input + " exists");
		
		log.trace("Creating new UserToAccount with user id " + userId + " and account id " + account.getId());
		UserToAccount userToAccount = new UserToAccount(user.getId(), account.getId());
		log.trace("Creating new UserToAccountDAO");
		JunctionDAO<UserToAccount> userToAccountDAO = new UserToAccountDAO();
		log.trace("Insert new UserToAccount to the database");
		userToAccountDAO.create(userToAccount);
		
		log.trace("Account share complete");
		System.out.println("Account has been shared! Press ENTER to return to the account management screen");
		log.trace("Getting user input");
		scan.nextLine();
		log.trace("Returning new AccountScreen");
		return new AccountScreen(userId);
	}
	
	/**
	 * Prompts user to select a starting account, destination account
	 * and an amount to transfer
	 */
	public Screen transfer() {
		System.out.println("Select the account you would like to transfer funds from, anything else to abort");
		log.trace("Creating new AccountSelector");
		AccountSelector accountSelector = new AccountSelector();
		log.trace("Calling method to display and select an account");
		Account startAccount = accountSelector.displayAndSelectAccount(userId);
		
		log.trace("Ensuring account has funds to transfer");
		if (startAccount == null) {
			log.trace("Account has no funds to tranfer, aborting transfer");
			System.out.println("Sorry, that account has no funds to transfer, please try again");
			return new AccountScreen(userId);
		}
		log.trace("Account has enough funds to transfer");
		
		System.out.println("Select the account you would like to transfer funds to, anything else to abort - returning new AccountScreen");
		log.trace("Calling method to display and select an account");
		Account destinationAccount = accountSelector.displayAndSelectAccount(userId);
		
		System.out.println("How much would you like to transfer?");
		log.trace("Getting user input");
		String input = scan.nextLine();
		
		log.trace("Ensureing the transfer amount does not exceed the starting account's balance");
		if (startAccount.getBalance() < Float.parseFloat(input)) {
			log.trace("User has insufficient funds for this transfer amount, abotring transfer - returning new AccountScreen");
			System.out.println("Sorry, your starting account does not have that much in its current balance, please try again");
			return new AccountScreen(userId);
		}
		
		log.trace("Creating new InputValidator");
		InputValidator inputValidator = new InputValidator();
		if (!inputValidator.isANumber(input)) {
			log.debug("User input was invalid - not a number input was 0 or negative, returning new AccountScreen");
			System.out.println("Sorry, amounts need to be a positive number, please try again.");
			return new AccountScreen(userId);
		}
		log.debug("User input is valid");
		log.trace("Converting input String to an Float amount");
		Float amount = Float.parseFloat(input);
		
		log.trace("begining transfer");
		startAccount.setBalance(startAccount.getBalance() - amount);
		destinationAccount.setBalance((destinationAccount.getBalance() + amount));
		log.trace("Creating new AccountDAO");
		DAO<Account> accountDAO = new AccountDAO();
		log.trace("Updating starting account");
		accountDAO.update(startAccount);
		log.trace("Updating destination account");
		accountDAO.update(destinationAccount);
		
		log.trace("transfer complete - returning new AccountScreen");
		return new AccountScreen(userId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
