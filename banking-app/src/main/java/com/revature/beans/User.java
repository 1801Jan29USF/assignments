package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8879967658657106165L;
	private String userName;
	private String password;
	private static Logger log = Logger.getRootLogger();
	private float balance;

	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	public User() {
		super();
		log.info("Creating user");
	}

	public User(String userName) {
		super();
		log.info("Creating bank");
		log.info("Setting this.userName");
		this.userName = userName;
	}

	public User(String userName, String password) {
		super();
		log.info("Creating bank");
		log.info("Setting this.userName");
		this.userName = userName;
		log.info("Setting this.password");
		this.password = password;
	}

	public User(String userName, String password, float balance, ArrayList<Transaction> transactions) {
		super();
		log.info("Creating bank");
		log.info("Setting this.userName");
		this.userName = userName;
		log.info("Setting this.password");
		this.password = password;
		log.info("Setting this.balance");
		this.balance = balance;
		log.info("Setting this.transactions");
		this.transactions = transactions;
	}

	@Override
	public int hashCode() {
		log.info("Calculating hashCode");
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		log.info("Returnting hashCode");
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
		User other = (User) obj;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance)) {
			log.info("Not equal, returning true");
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				log.info("Not equal, returning true");
				return false;
			}
		} else if (!password.equals(other.password)) {
			log.info("Not equal, returning true");
			return false;
		}
		if (transactions == null) {
			if (other.transactions != null) {
				log.info("Not equal, returning true");
				return false;
			}
		} else if (!transactions.equals(other.transactions)) {
			log.info("Not equal, returning true");
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				log.info("Not equal, returning true");
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			log.info("Not equal, returning true");
			return false;
		}
		log.info("Equal, returning true");
		return true;
	}

	public String getUserName() {
		log.info("Returning this.userName");
		return userName;
	}

	public void setUserName(String userName) {
		log.info("Setting this.userName");
		this.userName = userName;
	}

	public String getPassword() {
		log.info("Returning this.password");
		return password;
	}

	public void setPassword(String password) {
		log.info("Setting this.password");
		this.password = password;
	}

	public float getBalance() {
		log.info("Returning this.balance");
		return balance;
	}

	public void setBalance(float balance) {
		log.info("Setting this.balance");
		this.balance = balance;
	}

	public ArrayList<Transaction> getTransactions() {
		log.info("Returning this.transactions");
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		log.info("Setting this.transactions");
		this.transactions = transactions;
	}

	public String toString() {
		log.info("Converting user to a string");
		return "User [userName=" + userName + ", password=" + password + ", balance=" + balance + ", transactions="
				+ transactions + "]";
	}

}
