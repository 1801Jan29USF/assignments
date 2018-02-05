package com.revature.beans;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

public class Transaction implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1135181654910446828L;

	private float amount;
	
	private Date date;
	
	private static Logger log = Logger.getRootLogger();
	
	public Transaction() {
		super();
		log.info("Creating transaction");
	}
	
	public Transaction(float amount, Date date) {
		super();
		log.info("Creating transaction");
		log.info("Setting this.amount");
		this.amount = amount;
		log.info("Setting this.date");
		this.date = date;
	}

	@Override
	public int hashCode() {
		log.info("Getting hashCode");
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		log.info("Checking equals");
		if (this == obj) {
			log.info("Equal, returning true");
			return true;
		}
		if (obj == null) {
			log.info("Not equal, returning true");
			return false;
		}
		if (getClass() != obj.getClass()) {
			log.info("Not equal, returning true");
			return false;
		}
		Transaction other = (Transaction) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount)) {
			log.info("Not equal, returning true");
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				log.info("Not equal, returning true");
				return false;
			}
		} else if (!date.equals(other.date)) {
			log.info("Not equal, returning true");
			return false;
		}
		log.info("Equal, returning true");
		return true;
	}

	public float getAmount() {
		log.info("Returning this.amount");
		return amount;
	}

	public void setAmount(float amount) {
		log.info("Setting this.amount");
		this.amount = amount;
	}

	public Date getDate() {
		log.info("Returning this.date");
		return date;
	}

	public void setDate(Date date) {
		log.info("Setting this.date");
		this.date = date;
	}
	
	public String toString() {
		log.info("Converting transaction to a string");
		return "Transaction [amount=" + amount + ", date=" + date + "]";
	}
	
}
