package com.revature.beans;

import java.io.Serializable;
import java.util.Date;
/**
 * describes a transaction, which can belong to a user
 * @author Matt
 *
 */
public class Transaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2715939736168146013L;
	private double amount;
	private String date;
	
	public Transaction(double amount) {
		super();
		this.amount = amount;
		this.date = new Date().toString();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date.toString();
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", date=" + date + "]";
	}
	
	
}
