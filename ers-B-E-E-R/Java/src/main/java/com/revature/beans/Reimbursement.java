package com.revature.beans;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;

/**
 * Reimbursement class for the employee reimbursement system
 * Represents data stored in the ERS database's ers_reimbursement table
 * 
 * @author Bobby McGetrick
 *
 */
public class Reimbursement {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private int id;
	private float amount;
	private LocalDateTime submitted = LocalDateTime.now();
	private LocalDateTime resolved;
	private String description;
//	private Receipt receipt;
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new User
	 */
	public Reimbursement() {
		super();
		log.info("Constructing new Reimbursement");
		log.info("Called super constructor - Object");
		log.info("New Reimbursement created");
	}
	
	/**
	 * Create new Reimbursement based on user input on web page
	 * 
	 * @param amount
	 * @param submitted
	 * @param description
	 * @param authorId
	 * @param statusId
	 * @param typeId
	 */
	public Reimbursement(float amount, String description, int authorId, int statusId,
			int typeId) {
		super();
		this.amount = amount;
		this.description = description;
		this.authorId = authorId;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	
	public Reimbursement(int id, int statusId) {
		this.id = id;
		this.statusId = statusId;
	}

	public Reimbursement(float amount, String description, int typeId, LocalDateTime submited, LocalDateTime resolved, int authorId,
			int resolverId, int statusId) {
		super();
		this.amount = amount;
		this.description = description;
		this.authorId = authorId;
		this.statusId = statusId;
		this.typeId = typeId;
		this.resolverId = resolverId;
		this.submitted = submited;
		this.resolved = resolved;
	}
	
	public Reimbursement(int id, float amount, String description, int typeId, LocalDateTime submited, int authorId, int statusId) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.authorId = authorId;
		this.statusId = statusId;
		this.typeId = typeId;
		this.submitted = submited;
	}

	/**
	 * Create new Reimbursement with predefined values other than the id
	 * 
	 * @param float amount
	 * @param LocalDateTime submitted
	 * @param LocalDateTime resolved
	 * @param String description
	 * @param Receipt receipt
	 * @param int authorId
	 * @param int resovlerId
	 * @param int statusId
	 * @param int typeId
	 */
	public Reimbursement(float amount, LocalDateTime submitted, LocalDateTime resolved, String description,
			/*Receipt receipt,*/ int authorId, int resovlerId, int statusId, int typeId) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
//		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resovlerId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	/**
	 * Create new Reimbursement with predefined values
	 * 
	 * @param int id
	 * @param float amount
	 * @param LocalDateTime submitted
	 * @param LocalDateTime resolved
	 * @param String description
	 * @param Receipt receipt
	 * @param int authorId
	 * @param int resovlerId
	 * @param int statusId
	 * @param int typeId
	 */
	public Reimbursement(int id, float amount, LocalDateTime submitted, LocalDateTime resolved, String description,
			/*Receipt receipt,*/ int authorId, int resovlerId, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
//		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resovlerId;
		this.statusId = statusId;
		this.typeId = typeId;
	}	
	
	

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate User has code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + authorId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + resolverId;
		result = prime * result + statusId;
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + typeId;
		return result;
	}
	
	/**
	 * Check if User is equivalent to another Object
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
		Reimbursement other = (Reimbursement) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (authorId != other.authorId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolverId != other.resolverId)
			return false;
		if (statusId != other.statusId)
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		Reimbursement.log = log;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDateTime getSubmitted() {
		return submitted;
	}

	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}

	public LocalDateTime getResolved() {
		return resolved;
	}

	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResovlerId() {
		return resolverId;
	}

	public void setResovlerId(int resovlerId) {
		this.resolverId = resovlerId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}
