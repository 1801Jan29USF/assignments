package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.interfaces.DAO;

/**
* User service for the ERS
* Uses UserDAO to check if the combination of submitted user credentials
* exits in the ERS database, if so it returns the User with matching credentials
* from the ERS database
* 
* @author Bobby McGetrick
*
*/
public class UserService {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	 private static Logger log = Logger.getRootLogger();
	 
	 /************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new UserService
	 */
	 public UserService() {
			super();
	}
	 
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * No non-static fields
	 */
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve Object.log
	 * 
	 * @return Logger log
	 */
	 public static Logger getLog() {
		return log;
	}

	/**
	 * Set Object.log to a given Logger
	 * 
	 * @param Logger log
	 */
	public static void setLog(Logger log) {
		UserService.log = log;
	}
	
	/************************************************************************************
	 * Methods
	 ************************************************************************************/
	public User login(String username, String password) {
		log.trace("Creating new UserDAO");
		DAO<User> userDAO = new UserDAO();
		log.trace("Retrieving user fomr the database with username " + username + " and the given password");
		User user = userDAO.get(new User(username, password));
		
		log.trace("Check if user with submitted credentials exists in database");
		if (user != null) {
			log.trace("Login credentials were valid - returning the user with username " + username + " and the submitted password");
			return user;
		}
		log.trace("Login credentials were invalid - returning null");
		return null;
	}

}
