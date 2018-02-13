package com.revature.screens;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.AccountName;
import com.revature.beans.Password;
import com.revature.beans.User;
import com.revature.beans.UserToAccount;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountNameDAO;
import com.revature.dao.PasswordDAO;
import com.revature.dao.UserDAO;
import com.revature.dao.UserToAccountDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.Screen;
import com.revature.util.singleton.input.ScannerSingleton;

/**
 * Registration screen displayed to user for banking application
 * 
 * Prompts the user for a new user name and password and checks
 * if they are valid, if they are this Screen submits a SQL query
 * via various DAOs to register a new user to the bank based on the
 * user provided credentials 
 * 
 * @author Bobby McGetrick
 *
 */
public class RegistrationScreen implements Screen {
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new RegiatrationScreen
	 */
	public RegistrationScreen() {
		super();
		log.trace("Constructing new RegistrationScreen");
		log.trace("Called super constructor - Object");
		log.trace("New RegistrationScreen created");
		log.trace("Prompting RegistrationScreen");
		prompt();
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve RegistrationScreen.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		log.trace("Returning Logger: " + log);
		return log;
	}

	/**
	 * Retrieve RegistrationScreen.ScannerSingleton
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
	 * Overrides Screen.prompt() from the Screen interface
	 * 
	 * Displays banking application's registration menu to the user
	 * User can input through the console to enter a 
	 * user name and password
	 * If the user name is invalid or already taken
	 * then the user will get sent back to the initial OpenScreen
	 * 
	 * TODO Give the user the option to cancel registration
	 * 		and return to the initial OpenScreen
	 * 
	 * TODO Return the user to the registration screen instead
	 * 		of the initial OpenScreen upon entering a user name
	 * 		already in use
	 * 
	 * Displays new Screen based on user input
	 * 
	 * @return Screen
	 */
	@Override
	public Screen prompt() {
		log.trace("Displaying RegisrtationScreen menu");
		
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("Please enter you new user credentials");
		System.out.println("Username:");
		log.trace("Getting user input for their user name");
		String userName = scan.nextLine();
		log.debug("User submitted a user name");
		
		System.out.println("Password:");
		log.trace("Getting user input for their password");
		String password = scan.nextLine();
		log.debug("User submitted a password");
		
		log.trace("Calling method to validate user input");
		if (!validInput(userName, password)) {
			log.trace("Returing new OpenScreen");
			return new OpenScreen();
		}
		
		log.trace("Registering new user");
		return new MainMenu(register(userName, password));
	}
	
	/************************************************************************************
	 * Methods
	 ************************************************************************************/
	/**
	 * Takes 2 strings as inputs and checks if they are empty
	 * If either are empty returns false
	 * Otherwise returns true
	 * 
	 * @param String userName
	 * @param String password
	 * @return boolean
	 */
	private boolean validInput(String userName, String password) {
		log.trace("Check if either the submitted user name or paswword is empty");
		if (userName.isEmpty() || password.isEmpty()) {
			log.trace("User name/password invalid: empty string");
			System.out.println("User name/password cannot be empty, returning false");
			return false;
		}
		log.trace("Neither user name or password was empty, returning true");
		return true;
	}
	
	/**
	 * Takes a user name and password and creates a new user,
	 * password, account, account name and the relations between
	 * these objects and inserts them into the bank database
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	private int register(String userName, String password) {
		log.trace("Creating new Password and inserting it into the Bank database");
		Password newPassword = new Password(password);
		DAO<Password> passwordDAO = new PasswordDAO();
		int newPasswordId = passwordDAO.create(newPassword);
		log.debug("Inserted password with id: " + newPasswordId);
		
		log.trace("Creating new User and inserting it into the Bank database");
		User newUser = new User(newPasswordId, userName, new ArrayList<Integer>());
		DAO<User> userDAO = new UserDAO();
		int newUserId = userDAO.create(newUser);
		log.debug("Inserted user with id: " + newUserId);
		
		log.trace("Creating new AccountName and inserting it into the Bank database");
		AccountName newAccountName = new AccountName("Checking");
		DAO<AccountName> accountNameDAO = new AccountNameDAO();
		int newAccountNameId = accountNameDAO.create(newAccountName);
		log.debug("Inserted account name with id: " + newAccountNameId);
		
		log.trace("Creating new Account and inserting it into the Bank database");
		Account newAccount = new Account(newAccountNameId, 100.00f);
		DAO<Account> accountDAO = new AccountDAO();
		int newAccountId = accountDAO.create(newAccount);
		log.debug("Inserted account with id: " + newAccountId + " and account name id: " + newAccount.getAccountNameId());
		
		log.trace("Creating new UserToAccount and inserting it into the Bank database");
		UserToAccount newUserToAccount = new UserToAccount(newUser.getId(), newAccount.getId());
		DAO<UserToAccount> userToAccountDAO = new UserToAccountDAO();
		userToAccountDAO.create(newUserToAccount);
		log.debug("Inserted user to account with user id: " + newUserToAccount.getUserId() + " and account id: " + newUserToAccount.getAccountId());
		
		log.trace("Registration complete, returning new MainMenu");
		
		return newUserId;
	}

}
