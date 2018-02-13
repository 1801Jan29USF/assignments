package com.revature.beans;

import org.apache.log4j.Logger;

/**
 * Password class for banking application
 * Represents data stored in Bank database's passwords table
 * 
 * @author Bobby McGetrick
 *
 */
public class Password {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private int id;
	private String password;
	private static Logger log = Logger.getRootLogger();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Crate new Password
	 */
	public Password() {
		super();
		log.trace("Constructing new Password");
		log.trace("Called super constructor - Object");
		log.trace("New Password created");
	}
	
	/**
	 * Create new Password with predefined values
	 * except for the password id
	 * @param id
	 * @param password
	 */
	public Password(String password) {
		super();
		log.trace("Setting Password password = " + password);
		this.password = password;
		log.trace("New Password created");
	}
	
	/**
	 * Create new Password with predefined values
	 * @param id
	 * @param password
	 */
	public Password(int id, String password) {
		super();
		log.trace("Constructing new Password");
		log.trace("Called super constructor - Object");
		log.trace("Setting user id = " + id);
		this.id = id;
		log.trace("Setting Password password = " + password);
		this.password = password;
		log.trace("New Password created");
	}
	
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate Password hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/**
	 * Check if Password is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Password other = (Password) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	/**
	 * Retrieve Password.id
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set Password.id to a given integer
	 * @param int id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieve Password.password
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set Password.password to a given String
	 * @param String password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Retrieve Password.log
	 * @return Logger log
	 */
	public static Logger getLog() {
		return log;
	}

	/**
	 * Set Password.log to a given Logger
	 * @param Logger log
	 */
	public static void setLog(Logger log) {
		Password.log = log;
	}
	
	/************************************************************************************
	 * toString()
	 ************************************************************************************/
	/**
	 * Convert Password to a String listing Password's values
	 */
	public String toString() {
		log.trace("Converting Password to a string");
		return "Password"
				+ "[id=" + id
				+ ", password=" + password
				+ ", log=" + log + "]";
	}

}
