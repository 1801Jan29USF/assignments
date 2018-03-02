package com.revature.beans;

import org.apache.log4j.Logger;

/**
 * UserRole class for the employee reimbursement system
 * Represents data stored in the ERS database's ers_user_roles table
 * 
 * @author Bobby McGetrick
 *
 */
public class UserRole {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private int id;
	private String role;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new UserRole
	 */
	 public UserRole() {
			super();
			log.info("Constructing new UserRole");
			log.info("Called super constructor - Object");
			log.info("New UserRole created");
		}

	 /**
	  * Create new UserRole with predefined values other than the id
	  * 
	  * @param String status
	  */
	public UserRole(String status) {
		super();
		this.role = status;
	}

	/**
	 * Create new UserRole with predefined values
	 * 
	 * @param int id
	 * @param String status
	 */
	public UserRole(int id, String status) {
		super();
		this.id = id;
		this.role = status;
	}
	 
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate UserRole has code
	 */
	@Override
	public int hashCode() {
		log.info("Genrating UserRole hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		log.info("Returning UserRole hash code");
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		log.info("Checking if UserRole is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (id != other.id)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve UserRole.log
	 * 
	 * @return Logger log
	 */
	public static Logger getLog() {
		return log;
	}

	/**
	 * Set UserRole.log to a given Logger
	 * 
	 * @param Logger log
	 */
	public static void setLog(Logger log) {
		UserRole.log = log;
	}

	/**
	 * Retrieve UserRole.id
	 * 
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set UserRole.id to a given integer
	 * 
	 * @param int id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieve UserRole.role
	 * 
	 * @return String role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Set UserRole.role to a given String
	 * 
	 * @param String role
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
