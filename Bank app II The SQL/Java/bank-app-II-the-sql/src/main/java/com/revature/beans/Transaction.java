package com.revature.beans;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;

/**
 * Transaction class for banking application
 * Represents data stored in Bank database's transaction table
 * @author ramjr
 *
 */
public class Transaction {

	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private int id;
	private int userId;
	private int accountId;
	private float amountDeposited;
	private LocalDateTime date = LocalDateTime.now();
	private static Logger log = Logger.getRootLogger();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new Transaction
	 */
	public Transaction() {
		super();
		log.trace("Constructing new Transaction");
		log.trace("Called super constructor - Object");
		log.trace("New Transaction created");
	}
	
	/**
	 * Create new Transaction with predefined values except for id
	 * 
	 * @param int userId
	 * @param int accountId
	 * @param float amountDeposited
	 * @param Date date
	 */
	public Transaction(int userId, int accountId, float amountDeposited) {
		super();
		log.trace("Constructing new Transaction");
		log.trace("Called super constructor - Object");
		log.trace("Setting Transaction User id = " + userId );
		this.userId = userId;
		log.trace("Setting Transaction Account id = " + accountId);
		this.accountId = accountId;
		log.trace("Setting Transaction amount deposited = " + amountDeposited);
		this.amountDeposited = amountDeposited;
		log.trace("New Transaction created");
	}

	/**
	 * Create new Transaction with predefined values
	 * 
	 * @param int id
	 * @param int userId
	 * @param int accountId
	 * @param float amountDeposited
	 * @param Timestamp date
	 */
	public Transaction(int id, int userId, int accountId, float amountDeposited, LocalDateTime date) {
		super();
		log.trace("Constructing new Transaction");
		log.trace("Called super constructor - Object");
		log.trace("Setting Transaction id = " + id);
		this.id = id;
		log.trace("Setting Transaction User id = " + userId );
		this.userId = userId;
		log.trace("Setting Transaction Account id = " + accountId);
		this.accountId = accountId;
		log.trace("Setting Transaction amount deposited = " + amountDeposited);
		this.amountDeposited = amountDeposited;
		log.trace("Setting Transaction tiemstamp = " + date);
		this.date = date;
		log.trace("New Transaction created");
	}

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate Transaction hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating Transaction hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + Float.floatToIntBits(amountDeposited);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + userId;
		log.trace("Returning Transaction hash code");
		return result;
	}

	/**
	 * Check if Transaction is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if Transaction is equivalent to the pass Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (accountId != other.accountId)
			return false;
		if (Float.floatToIntBits(amountDeposited) != Float.floatToIntBits(other.amountDeposited))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve Transaction.id
	 * @return int id
	 */
	public int getId() {
		log.trace("Returning Transction id: " + id);
		return id;
	}

	/**
	 * Set Transaction.id to a given integer
	 * @param int id
	 */
	public void setId(int id) {
		log.trace("Setting Transction id = " + id);
		this.id = id;
	}

	/**
	 * Retrieve Transaction.userId
	 * @return int userId
	 */
	public int getUserId() {
		log.trace("Returning Transction User id: " + userId);
		return userId;
	}

	/**
	 * Set Transaction.userId to a given integer
	 * @param int userId
	 */
	public void setUserId(int userId) {
		log.trace("Setting Transction User id = " + userId);
		this.userId = userId;
	}

	/**
	 * Retrieve Transaction.accountId
	 * @param int accountId
	 */
	public int getAccountId() {
		log.trace("Returning Transction Account id: " + accountId);
		return accountId;
	}

	/**
	 * Set Transaction.accountId to a given integer
	 * @param int accountId
	 */
	public void setAccountId(int accountId) {
		log.trace("Setting Transction Account id = " + accountId);
		this.accountId = accountId;
	}

	/**
	 * Retrieve Transaction.amountDeposited
	 * @param float amountDeposited
	 */
	public float getAmountDeposited() {
		log.trace("Returning Transction amount deposited: " + amountDeposited);
		return amountDeposited;
	}

	/**
	 * Set Transaction.acamountDeposited to a given float
	 * @param float amountDeposited
	 */
	public void setAmountDeposited(float amountDeposited) {
		log.trace("Setting Transction amount deposited = " + amountDeposited);
		this.amountDeposited = amountDeposited;
	}

	/**
	 * Retrieve Transaction.date
	 * @return LocalDateTime date
	 */
	public LocalDateTime getDate() {
		log.trace("Returning Transaction Date: " + date);
		return date;
	}

	/**
	 * Set Transaction.date to a given LocalTimeStamp
	 * @param LocalDateTime date
	 */
	public void setDate(LocalDateTime date) {
		log.trace("Setting Transaction TimeStamp = " + date);
		this.date = date;
	}

	/**
	 * Retrieve Transaction.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		log.trace("Returning Transaction Logger: " + log);
		return log;
	}

	/**
	 * Set Transaction.log to a given Logger
	 * @param log
	 */
	public static void setLog(Logger log) {
		log.trace("Setting Transaction Logger = " + log);
		Transaction.log = log;
	}
	
	/************************************************************************************
	 * toString()
	 ************************************************************************************/
	/**
	 * Convert Transaction to a String listing Transaction's values
	 */
	public String toString() {
		log.info("Converting Transaction to a string");
		return "Transaction ["
				+ "id=" + id
				+ "userId=" + userId
				+ "accountId=" +accountId
				+ ", amountDeposited=" + amountDeposited
				+ ", date=" + date
				+ ", log=" + log + "]";
	}
	
}
