package com.revature.bank.bean;

import java.io.Serializable;

public class User implements Serializable {

	/**This is a User bean for the Banking application. User class implements Serializable to all 
	 * objects to be converted to code to be saved in .txt file. The Bank app have many users. 
	 * A user can register for new account, loging, view balance, make deposit, and withdaw. 
	 * The user bean has user, passord and balance variable to store these data. Getters and setters 
	 * are used to retrieve variabls. 
	 * deposit method allows user to make deposit. Withdraw method allows user to make a withdaw.	 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private double balance;
	// private static User user = new User();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String password, double balance) {
		super();
		this.userName = userName;
		this.password = password;
		this.balance = balance;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " [userName=" + userName + ", password=" + password + ", balance=" + balance + "]";
	}

	public void deposit(double amount) {

		this.balance = this.balance + amount;
	}
	
	
	public void withdraw(double amount) {
		
		this.balance = this.balance - amount;


	}

}
