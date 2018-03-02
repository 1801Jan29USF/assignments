package com.revature.beans;

import org.apache.log4j.Logger;

/**
 * ReimbursementType class for the employee reimbursement system
 * Represents data stored in the ERS database's ers_reimbursement_type table
 * 
 * @author Bobby McGetrick
 *
 */
public class ReimbursementType {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private int id;
	private String type;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new ReimbursementType
	 */
	 public ReimbursementType() {
			super();
			log.info("Constructing new ReimbursementType");
			log.info("Called super constructor - Object");
			log.info("New ReimbursementType created");
		}

	 /**
	  * Create new ReimbursementType with predefined values other than the id
	  * 
	  * @param String type
	  */
	public ReimbursementType(String type) {
		super();
		this.type = type;
	}

	/**
	 * Create new ReimbursementType with predefined values
	 * 
	 * @param int id
	 * @param String type
	 */
	public ReimbursementType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	 
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate ReimbursementType has code
	 */
	@Override
	public int hashCode() {
		log.info("Genrating ReimbursementType hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		log.info("Returning ReimbursementType hash code");
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		log.info("Checking if ReimbursementType is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementType other = (ReimbursementType) obj;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve ReimbursementType.log
	 * 
	 * @return Logger log
	 */
	public static Logger getLog() {
		return log;
	}

	/**
	 * Set ReimbursementType.log to a given Logger
	 * 
	 * @param Logger log
	 */
	public static void setLog(Logger log) {
		ReimbursementType.log = log;
	}

	/**
	 * Retrieve ReimbursementType.id
	 * 
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set ReimbursementType.id to a given integer
	 * 
	 * @param int id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retrieve ReimbursementType.type
	 * 
	 * @return String type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set ReimbursementType.type to a given String
	 * 
	 * @param String type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
