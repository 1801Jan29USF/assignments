package com.revature.beans;

import org.apache.log4j.Logger;

/**
 * ReimbursementStatus class for the employee reimbursement system
 * Represents data stored in the ERS database's ers_reimbursement_status table
 * 
 * @author Bobby McGetrick
 *
 */
public class ReimbursementStatus {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private int id;
	private String status;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new ReimbursementStatus
	 */
	 public ReimbursementStatus() {
			super();
			log.info("Constructing new ReimbursementStatus");
			log.info("Called super constructor - Object");
			log.info("New ReimbursementStatus created");
		}

	 /**
	  * Create new ReimbursementStatus with predefined values other than the id
	  * 
	  * @param String status
	  */
	public ReimbursementStatus(String status) {
		super();
		this.status = status;
	}

	/**
	 * Create new ReimbursementStatus with predefined values
	 * 
	 * @param int id
	 * @param String status
	 */
	public ReimbursementStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	 
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate ReimbursementStatus hash code
	 */
	@Override
	public int hashCode() {
		log.info("Genrating ReimbursementStatus hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		log.info("Returning ReimbursementStatus hash code");
		return result;
	}

	/**
	 * Check if ReimbursementStatus is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.info("Checking if ReimbursementStatus is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve ReimbursementStatus.log
	 * 
	 * @return Logger log
	 */
	public static Logger getLog() {
		return log;
	}

	/**
	 * Set ReimbursementStatus.log to a given Logger
	 * 
	 * @param Logger log
	 */
	public static void setLog(Logger log) {
		ReimbursementStatus.log = log;
	}

	/**
	 * Retrieve ReimbursementStatus.id
	 * 
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set ReimbursementStatus.id to a given integer
	 * 
	 * @param int id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieve ReimbursementStatus.status
	 * 
	 * @return String status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set ReimbursementStatus.status to a given String
	 * 
	 * @param String status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
