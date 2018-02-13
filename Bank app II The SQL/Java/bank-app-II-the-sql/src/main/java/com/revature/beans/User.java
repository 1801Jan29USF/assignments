package com.revature.beans;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * User class for banking application
 * Represents data stored in Bank database's users table
 * 
 * @author Bobby McGetrick
 *
 */
public class User {

	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private int id;
	private int passwordId;
	private String userName;
	private static Logger log = Logger.getRootLogger();
	private ArrayList<Integer> transactionIds = new ArrayList<Integer>();

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Crate new User
	 */
	public User() {
		super();
		log.trace("Constructing new User");
		log.trace("Called super constructor - Object");
		log.trace("New User created");
	}

	/**
	 * Create new User with predefined values
	 * except for the user id
	 * @param String userName
	 * @param ArrayList<Integer> transactionIds
	 */
	public User(int passwordId, String userName, /*String password,*/ ArrayList<Integer> transactionIds) {
		super();
		log.trace("Constructing new User");
		log.trace("Called super constructor - Object");
		log.trace("Setting user passwordId = " + passwordId);
		this.passwordId = passwordId;
		log.trace("Setting User name = " + userName);
		this.userName = userName;
		/*log.trace("Setting User password = " + password);
		this.password = password;*/
		log.trace("Setting User transaction id ArrayList = " + transactionIds);
		this.transactionIds = transactionIds;
		log.trace("New User created");
	}
	
	/**
	 * Create new User with predefined values
	 * @param int id
	 * @param int passwordId
	 * @param String userName
	 * @param ArrayList<Integer> transactionIds
	 */
	public User(int id, int passwordId, String userName, ArrayList<Integer> transactionIds) {
		super();
		log.trace("Constructing new User");
		log.trace("Called super constructor - Object");
		log.trace("Setting user id = " + id);
		this.id = id;
		log.trace("Setting user passwrodId = " + passwordId);
		this.passwordId = passwordId;
		log.trace("Setting User name = " + userName);
		this.userName = userName;
		log.trace("Setting User transaction id ArrayList = " + transactionIds);
		this.transactionIds = transactionIds;
		log.trace("New User created");
	}
	
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate User hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating User hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + passwordId;
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((transactionIds == null) ? 0 : transactionIds.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		log.trace("Returning User hash code");
		return result;
	}

	/**
	 * Check if User is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if User is equivalent to the pass Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (id != other.passwordId)
			return false;
		if (transactionIds == null) {
			if (other.transactionIds != null)
				return false;
		} else if (!transactionIds.equals(other.transactionIds))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve User.id
	 * @return int id
	 */
	public int getId() {
		log.trace("Returning  User id: " + id);
		return id;
	}
	
	/**
	 * Set User.id to a given integer
	 * @param int id
	 */
	public void setId(int id) {
		log.trace("Setting User id = " + id);
		this.id = id;
	}
	
	/**
	 * Retrieve User.passwordd
	 * @return int passwordId
	 */
	public int getPasswordId() {
		log.trace("Returning  User password id: " + passwordId);
		return passwordId;
	}
	
	/**
	 * Set User.passwordId to a given integer
	 * @param int passwordId
	 */
	public void setPasswordIId(int passwordId) {
		log.trace("Setting User password id = " + passwordId);
		this.passwordId = passwordId;
	}

	/**
	 * Retrieve User.name
	 * @return String name
	 */
	public String getUserName() {
		log.trace("Returning  User name: " + userName);
		return userName;
	}


	/**
	 * Set User.name to a given String
	 * @param String name
	 */
	public void setUserName(String userName) {
		log.trace("Setting User name = " + userName);
		this.userName = userName;
	}

	/**
	 * Retrieve User.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		log.trace("Returning User Logger: " + log);
		return log;
	}

	/**
	 * Set User.log to a given Logger
	 * @param Logger log
	 */
	public static void setLog(Logger log) {
		log.trace("Setting User Logger = " + log);
		User.log = log;
	}

	/**
	 * Retrieve User getTransactionIds
	 * @return ArrayList<Integer> getTransactionIds
	 */
	public ArrayList<Integer> getTransactionIds() {
		log.trace("Returning  User transaction id ArrayList: " + transactionIds);
		return transactionIds;
	}

	/**
	 * Set User.transactionIds to a given ArrayList<Integer>
	 * @param ArrayList<Integer> transactionIds
	 */
	public void setTransactionIds(ArrayList<Integer> transactionIds) {
		log.trace("Setting  User transaction id ArrayList = " + transactionIds);
		this.transactionIds = transactionIds;
	}

	/************************************************************************************
	 * toString()
	 ************************************************************************************/
	/**
	 * Convert User to a String listing User's values
	 */
	public String toString() {
		log.trace("Converting User to a string");
		return "User"
				+ "[id=" + id
				+ ", userName=" + userName
				+ ", transactionIds=" + transactionIds
				+ ", log=" + log + "]";
	}

}
