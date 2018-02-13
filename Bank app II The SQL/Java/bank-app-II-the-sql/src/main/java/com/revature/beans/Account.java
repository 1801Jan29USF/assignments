package com.revature.beans;

import org.apache.log4j.Logger;

/**
 * Account class for banking application
 * Represents data stored in Bank database's account table
 * 
 * @author Bobby McGetrick
 *
 */
public class Account {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private int id;
	private int accountNameId;
//	private String accountName;
	private float balance;
	private Logger log = Logger.getRootLogger();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new Account
	 */
	public Account() {
		super();
		log.trace("Constructing new Account");
		log.trace("Called super constructor - Object");
		log.trace("New Account created");
	}
	
	/**
	 * Create new Account with predefined values
	 * except for the account id
	 * @param int accountNameId
	 * @param float balance
	 */
	public Account(int accountNameId, float balance) {
		super();
		log.trace("Constructing new Account");
		log.trace("Called super constructor - Object");
		log.trace("Setting account accountNameId = " + accountNameId);
		this.accountNameId = accountNameId;
		log.trace("Setting Account balance = " + balance);
		this.balance = balance;
		log.trace("New Account created");
	}

	/**
	 * Create new Account with predefined values
	 * @param int id
	 * @param int accountNameId
	 * @param float balance
	 */
	public Account(int id, int accountNameId, float balance) {
		super();
		log.trace("Constructing new Account");
		log.trace("Called super constructor - Object");
		log.trace("Setting Account id = " + id);
		this.id = id;
		log.trace("Setting Account accountNameId = " + accountNameId);
		this.accountNameId = accountNameId;
//		log.trace("Setting Account name = " + accountName);
//		this.accountName = accountName;
		log.trace("Setting Account balance = " + balance);
		this.balance = balance;
		log.trace("New Account created");
	}
	
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate Account hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating Account hash code");
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + id;
		result = prime * result + accountNameId;
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		log.trace("Returning Account hash code");
		return result;
	}

	/**
	 * Check if Account is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if Account is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (id != other.accountNameId)
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
	 * Retrieve Account.id
	 * @return int id
	 */
	public int getId() {
		log.trace("Returning Account id: " + id);
		return id;
	}

	/**
	 * Set Account id to a given integer
	 * @param int id
	 */
	public void setId(int id) {
		log.trace("Setting Account id = " + id);
		this.id = id;
	}
	
	/**
	 * Retrieve Account.accountNameId
	 * @return int accountNameId
	 */
	public int getAccountNameId() {
		log.trace("Returning Account accountNameId: " + accountNameId);
		return accountNameId;
	}

	/**
	 * Set Account accountNameId to a given integer
	 * @param int accountNameId
	 */
	public void setaccountNameId(int accountNameId) {
		log.trace("Setting Account accountNameId = " + accountNameId);
		this.accountNameId = accountNameId;
	}

//	/**
//	 * Retrieve Account.name
//	 * @return String name
//	 */
//	public String getAccountName() {
//		log.trace("Returning Account name: " + accountName);
//		return accountName;
//	}
//
//	/**
//	 * Set Account.name to a given String
//	 * @param String accountName
//	 */
//	public void setAccountName(String accountName) {
//		log.trace("Setting Account name = " + accountName);
//		this.accountName = accountName;
//	}

	/**
	 * Retrieve Account.balance
	 * @return float balance
	 */
	public float getBalance() {
		log.trace("Returning Account balance: " + balance);
		return balance;
	}

	/**
	 * Set Account.balance to a given float
	 * @param float balance
	 */
	public void setBalance(float balance) {
		log.trace("Setting Account balance = " + balance);
		log.trace("Check if new balance is negative");
		if (balance >= 0) {
			log.trace("New balance is valid, upadting balance");
			this.balance = balance;
		} else {
			log.trace("New balance was invalid - negative balance, balance not updated");
		}
	}

	/**
	 * Retrieve Account.log
	 * @return Logger log
	 */
	public Logger getLog() {
		log.trace("Returning Account Logger: " + log);
		return log;
	}

	/**
	 * Set Account.log to a given Logger
	 * @param Logger log
	 */
	public void setLog(Logger log) {
		log.trace("Setting Account Logger = " + log);
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
				+ "accountNameId=" + accountNameId
//				+ ", accountName=" + accountName
				+ ", ballance=" + balance
				+ ", log=" + log + "]";
	}
	
}
