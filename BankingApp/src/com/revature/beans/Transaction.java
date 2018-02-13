package com.revature.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * For use in the BankUser bean. A Transaction holds a string representation of
 * a deposit or withdrawal (either "deposited" or "withdrew"), an amount of
 * money, and a date storing when the transaction took place. These are used in
 * printing a user's transaction history.
 * 
 * @author poblo
 *
 */
public class Transaction implements Serializable {
	private static final long serialVersionUID = 5072831834288267654L;
	String action;
	Double amount;
	Date dateAndTime;
	String username;

	public Transaction(Double amount, Date dateAndTime, String username) {
		super();
		this.action = "Deposited";
		if (amount < 0.0) {
			this.action = "Withdrew";
			this.amount = amount * -1.0;
		} else {
			this.amount = amount;
		}
		this.dateAndTime = dateAndTime;
		this.username = username;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	public String toString() {
		return "On " + this.getDateAndTime() + ", " + this.username + " " + this.getAction() + " $"
				+ this.getAmount() + ".";
	}

}
