//package com.revature.beans;
//
//import org.apache.log4j.Logger;
//
///**
// * AccountToAccountName class for banking application
// * Represents data stored in Bank database's account_to_account_name junction table
// *
// * @author Bobby McGetrick
// *
// */
//public class AccountToAccountName {
//	
//	/************************************************************************************
//	 * Private fields
//	 ************************************************************************************/
//	private int accountId;
//	private int nameId;
//	private Logger log = Logger.getRootLogger();
//	
//	/************************************************************************************
//	 * Constructors
//	 ************************************************************************************/
//	/**
//	 * Crate new AccountToAccountName
//	 */
//	public AccountToAccountName() {
//		super();
//		log.trace("Constructing new AccountToAccountName");
//		log.trace("Called super constructor - Object");
//		log.trace("New AccountToAccountName created");
//	}
//
//	/**
//	 * Create new AccountToAccountName with predefined values
//	 * @param accountId
//	 * @param nameId
//	 * @param log
//	 */
//	public AccountToAccountName(int accountId, int nameId) {
//		super();
//		this.accountId = accountId;
//		this.nameId = nameId;
//	}
//
//	/************************************************************************************
//	 * haschCode() and equals()
//	 ************************************************************************************/
//	/**
//	 * Generate AccountToAccountName hash code
//	 */
//	@Override
//	public int hashCode() {
//		log.trace("Genrating AccountToAccountName hash code");
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + accountId;
//		result = prime * result + ((log == null) ? 0 : log.hashCode());
//		result = prime * result + nameId;
//		log.trace("Returning AccountToAccountName hash code");
//		return result;
//	}
//
//	/**
//	 * Check if AccountToAccountName is equivalent to another Object
//	 * @param Object obj
//	 */
//	@Override
//	public boolean equals(Object obj) {
//		log.trace("Checking if AccountToAccountName is equivalent to the pass Object " + obj );
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		AccountToAccountName other = (AccountToAccountName) obj;
//		if (accountId != other.accountId)
//			return false;
//		if (log == null) {
//			if (other.log != null)
//				return false;
//		} else if (!log.equals(other.log))
//			return false;
//		if (nameId != other.nameId)
//			return false;
//		return true;
//	}
//	
//	/************************************************************************************
//	 * Getters and Setters
//	 ************************************************************************************/
//	/**
//	 * Retrieve AccountToAccountName.accountId
//	 * @return int accountId
//	 */
//	public int getAccountId() {
//		log.trace("Returning UserToAccount account id: " + accountId);
//		return accountId;
//	}
//
//	/**
//	 * Setting AccountToAccountName.accountId
//	 * @param int accountId
//	 */
//	public void setAccountId(int accountId) {
//		log.trace("Setting UserToAccount account id = " + accountId);
//		this.accountId = accountId;
//	}
//
//	/**
//	 * Retrieve AccountToAccountName.nameId
//	 * @return int nameId
//	 */
//	public int getNameId() {
//		log.trace("Returning UserToAccount account name id: " + nameId);
//		return nameId;
//	}
//
//	/**
//	 * Setting AccountToAccountName.nameId
//	 * @param int nameId
//	 */
//	public void setNameId(int nameId) {
//		log.trace("Setting UserToAccount account name id = " + nameId);
//		this.nameId = nameId;
//	}
//
//	/**
//	 * Retrieve AccountToAccountName.log
//	 * @return Logger log
//	 */
//	public Logger getLog() {
//		log.trace("Returning AccountToAccountName Logger: " + log);
//		return log;
//	}
//
//	/**
//	 * Set AccountToAccountName.log to a given Logger
//	 * @param Logger log
//	 */
//	public void setLog(Logger log) {
//		log.trace("Setting AccountToAccountName Logger = " + log);
//		this.log = log;
//	}
//	
//}
