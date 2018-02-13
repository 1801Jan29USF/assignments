package com.revature.beans;

import org.apache.log4j.Logger;

/**
 * UserToAccount class for banking application
 * Represents data stored in Bank database's user_to_account junction table
 *
 * @author Bobby McGetrick
 *
 */
public class UserToAccount {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private int userId;
	private int accountId;
	private Logger log = Logger.getRootLogger();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Crate new UserToAccount
	 */
	public UserToAccount() {
		super();
		log.trace("Constructing new UserToAccount");
		log.trace("Called super constructor - Object");
		log.trace("New UserToAccount created");
	}

	/**
	 * Create new UserToAccount with predefined values
	 * @param int userId
	 * @param int accountId
	 */
	public UserToAccount(int userId, int accountId) {
		super();
		log.trace("Constructing new UserToAccount");
		log.trace("Called super constructor - Object");
		log.trace("Setting UserToAccount User id = " + userId);
		this.userId = userId;
		log.trace("Setting UserToAccount Account id = " + accountId);
		this.accountId = accountId;
		log.trace("New UserToAccount created");
	}
	
	/************************************************************************************
	 * haschCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate UserToAccount hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating UserToAccount hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		result = prime * result + userId;
		log.trace("Returning UserToAccount hash code");
		return result;
	}

	/**
	 * Check if UserToAccount is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if UserToAccount is equivalent to the pass Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserToAccount other = (UserToAccount) obj;
		if (accountId != other.accountId)
			return false;
		if (log == null) {
			if (other.log != null)
				return false;
		} else if (!log.equals(other.log))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve UserToAccount.userId
	 * @return int userId
	 */
	public int getUserId() {
		log.trace("Returning UserToAccount User id: " + userId);
		return userId;
	}

	/**
	 * Set UserToAccount.userId to a given integer
	 * @param int userId
	 */
	public void setUserId(int userId) {
		log.trace("Setting UserToAccount User id = " + userId);
		this.userId = userId;
	}

	/**
	 * Retrieve UserToAccount.accountId
	 * @return int accountId
	 */
	public int getAccountId() {
		log.trace("Returning UserToAccount Account id: " + accountId);
		return accountId;
	}

	/**
	 * Set UserToAccount.accountId to a given integer
	 * @param int accountId
	 */
	public void setAccountId(int accountId) {
		log.trace("Setting UserToAccount Account id = " + accountId);
		this.accountId = accountId;
	}

	/**
	 * Retrieve UserToAccount.log
	 * @return Logger log
	 */
	public Logger getLog() {
		log.trace("Returning UserToAccount Logger: " + log);
		return log;
	}

	/**
	 * Set UserToAccount.log to a given Logger
	 * @param Logger log
	 */
	public void setLog(Logger log) {
		log.trace("Setting UserToAccount Logger = " + log);
		this.log = log;
	}
	
	/************************************************************************************
	 * toString()
	 ************************************************************************************/
	/**
	 * Convert UserToAccount to a String listing UserToAccount's values
	 */
	public String toString() {
		log.trace("Converting UserToAccount to a string");
		return "UserToAccount ["
				+ "userId=" + userId
				+ ", accountId=" + accountId
				+ ", log=" + log + "]";
	}

}
