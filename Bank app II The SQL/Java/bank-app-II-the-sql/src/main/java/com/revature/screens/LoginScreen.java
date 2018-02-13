package com.revature.screens;

import org.apache.log4j.Logger;

import com.revature.beans.Password;
import com.revature.beans.User;
import com.revature.dao.PasswordDAO;
import com.revature.dao.UserDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.Screen;
import com.revature.util.singleton.input.ScannerSingleton;

/**
 * Login screen displayed to user for banking application
 * 
 * Prompts the user for a user name and password and checks
 * if they are valid, if they are this Screen submits a SQL query
 * via UserDAO and PasswordDAO to log a new user to the database based on the
 * user provided credentials 
 * 
 * @author Bobby McGetrick
 *
 */
public class LoginScreen implements Screen {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new LoginScreen
	 */
	public LoginScreen() {
		super();
		log.trace("Constructing new LoginScreen");
		log.trace("Called super constructor - Object");
		log.trace("New LoginScreen created");
		log.trace("Prompting LoginScreen");
		prompt();
	}
	
	/************************************************************************************
	 * hashCode() & equals()
	 ************************************************************************************/
	/**
	 * Generate LoginScreen hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating LoginScreen hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scan == null) ? 0 : scan.hashCode());
		log.trace("Returning LoginScreen hash code");
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if LoginScreen is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginScreen other = (LoginScreen) obj;
		if (scan == null) {
			if (other.scan != null)
				return false;
		} else if (!scan.equals(other.scan))
			return false;
		return true;
	}

	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve LoginScreen.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		log.trace("Returning Logger: " + log);
		return log;
	}
	
	/**
	 * Setting LoginScreen.log to a given Logger
	 * @return ScannerSingleton scan
	 */
	public static void setLog(Logger log) {
		log.trace("Setting Logger = " + log);
		LoginScreen.log = log;
	}

	/**
	 * Retrieve LoginScreen.ScannerSingleton
	 * @return ScannerSingleton scan
	 */
	public ScannerSingleton getScan() {
		log.trace("Returning ScannerSingleton = " + scan);
		return scan;
	}
	
	/**
	 * Setting LoginScreen.scan to a given SannerSingleton
	 * @return ScannerSingleton scan
	 */
	public void setScan(ScannerSingleton scan) {
		log.trace("Setting ScannerSingleton = " + scan);
		this.scan = scan;
	}

	/************************************************************************************
	 * Overrides
	 ************************************************************************************/
	/**
	 * Overrides Screen.prompt() from the Screen interface
	 * 
	 * Displays banking application's login menu to the user
	 * User can input through the console to enter a 
	 * user name and password
	 * If the user name does not exists or does not relate to
	 * the submitted password then the user will get sent back 
	 * to the initial OpenScreen
	 * 
	 * TODO Give the user the option to cancel login
	 * 		and return to the initial OpenScreen
	 * 
	 * TODO Return the user to the login screen instead
	 * 		of the initial OpenScreen upon entering invalid
	 * 		login credentials
	 * 
	 * Displays new Screen based on user input
	 * 
	 * @return Screen
	 */
	@Override
	public Screen prompt() {
		log.info("Displaying LoginScreen menu");
		
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("Please enter your user credentials below");
		System.out.println("Username:");
		log.trace("Getting user input for their user name");
		String userName = scan.nextLine();
		log.debug("User submitted a user name");
		
		System.out.println("Password:");
		log.trace("Getting user input for their password");
		String password = scan.nextLine();
		log.debug("User submitted a password");
		
		log.trace("Veryfying credentials");
		if (validInput(userName, password) && validCredentials(userName, password)) {
			log.debug("User submitted valid credentials, logging user in");
			log.trace("Returning new MainMenu with user id of user " + userName);
			return new MainMenu(getUserId(userName));
		}
		
		log.trace("Inavlid user credentials, returning new OpenScreen");
		System.out.println("User name/password was inccorect, please try again");
		return new OpenScreen();
	}
	
	/************************************************************************************
	 * Methods
	 ************************************************************************************/
	/**
	 * Takes 2 strings as user name and password inputs and 
	 * checks if they are empty
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
	 * Check if both the user name and password are in teh bank
	 * database
	 * If they are, checks to see if the password id on both the
	 * user name and password match
	 * If they match returns true
	 * If any check fails returns false
	 * 
	 * @param userName
	 * @param password
	 * 
	 * @return boolean
	 */
	private boolean validCredentials (String userName, String password) {
		log.trace("Creating new UserDAO");
		DAO<User> userDAO = new UserDAO();
		log.trace("Creating new PasswordDAO");
		DAO<Password> passwordDAO = new PasswordDAO();
		
		log.trace("Creating new User via the UserDAO");
		User user = userDAO.get(userName);
		log.trace("Creating new Password via the PasswordDAO");
		Password pw = passwordDAO.get(password);
		
		log.trace("Checking if either the user name or password was found in the databse");
		if (user == null || pw == null) {
			log.debug("User name/Password does not exist in the database, returing false");
			return false;
		}
		
		log.trace("Checking if retrieved user name and password relate to one another");
		if (user.getPasswordId() != pw.getId()) {
			log.trace("User name and password to not relate to each other, returning flase");
			return false;
		}
		
		log.trace("User name and password exist and relate to one another, returning true");
		return true;
	}
	
	/**
	 * Queries the database for a user id given a user name
	 * 
	 * @param userName
	 * @return int
	 */
	private int getUserId(String userName) {
		log.trace("Creating new UserDAO");
		DAO<User> userDAO = new UserDAO();
		
		log.trace("Returnging user id of user " + userName);
		return userDAO.get(userName).getId();
	}

}
