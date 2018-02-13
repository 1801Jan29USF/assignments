package com.revature.beans;

import org.apache.log4j.Logger;

/**
 * Account class for banking application
 * Represents data stored in Bank database's account table
 * 
 * @author Bobby McGetrick
 *
 */
public class AccountName {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private int id;
	private String accountName;
	private Logger log = Logger.getRootLogger();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new Account
	 */
	public AccountName() {
		super();
		log.trace("Constructing new AccountName");
		log.trace("Called super constructor - Object");
		log.trace("New AccountName created");
	}
	
	/**
	 * Create new AccountName with predefined values
	 * except for accountName
	 * @param int id
	 */
	public AccountName( String accountName) {
		super();
		log.trace("Constructing new AccountName");
		log.trace("Called super constructor - Object");
		log.trace("Setting Account accountName = " + accountName);
		this.accountName = accountName;
		log.trace("New AccountName created");
	}

	/**
	 * Create new AccountName with predefined values
	 * @param int id
	 * @param String accountName
	 */
	public AccountName(int id, String accountName) {
		super();
		log.trace("Constructing new AccountName");
		log.trace("Called super constructor - Object");
		log.trace("Setting Account id = " + id);
		this.id = id;
		log.trace("Setting Account accountName = " + accountName);
		this.accountName = accountName;
	}
	
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate Account hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating AccountName hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + id;
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		log.trace("Returning AccountName hash code");
		return result;
	}

	/**
	 * Check if AccountName is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if AccountName is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountName other = (AccountName) obj;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (id != other.id)
			return false;
		if (log == null) {
			if (other.log != null)
				return false;
		} else if (!log.equals(other.log))
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve AccountName.id
	 * @return int id
	 */
	public int getId() {
		log.trace("Returning AccountName id: " + id);
		return id;
	}

	/**
	 * Set AccountName id to a given integer
	 * @param int id
	 */
	public void setId(int id) {
		log.trace("Setting AccountName id = " + id);
		this.id = id;
	}
	
	/**
	 * Retrieve AccountName.acountName
	 * @return String name
	 */
	public String getAccountName() {
		log.trace("Returning Account name: " + accountName);
		return accountName;
	}

	/**
	 * Set AccountName.accountName to a given String
	 * @param String accountName
	 */
	public void setAccountName(String accountName) {
		log.trace("Setting Account name = " + accountName);
		this.accountName = accountName;
	}
	
	/**
	 * Retrieve AccountName.log
	 * @return Logger log
	 */
	public Logger getLog() {
		log.trace("Returning AccountName Logger: " + log);
		return log;
	}

	/**
	 * Set AccountName.log to a given Logger
	 * @param Logger log
	 */
	public void setLog(Logger log) {
		log.trace("Setting AccountName Logger = " + log);
		this.log = log;
	}
	
	/************************************************************************************
	 * toString()
	 ************************************************************************************/
	/**
	 * Convert Account to a String listing Account's values
	 */
	public String toString() {
		log.trace("Converting Transaction to a string");
		return "Account ["
				+ "id= " + id
				+ "accountName=" + accountName + "]";
	}

}
