package com.revature.bankapp;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Bank user class which holds the personal info of each user account in our bank.
 * @author Rick
 *
 */
public class BankUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private double balance;
	private double deposit;
	private double withdraw;
	private ArrayList<String> transactions= new ArrayList<String>();

	public BankUser(String username, String password, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
		
	}

	public ArrayList<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<String> transactions) {
		this.transactions = transactions;
	}

	public BankUser() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
		this.balance += deposit;
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
		this.balance -= withdraw;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(deposit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		temp = Double.doubleToLongBits(withdraw);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankUser other = (BankUser) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (Double.doubleToLongBits(deposit) != Double.doubleToLongBits(other.deposit))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (Double.doubleToLongBits(withdraw) != Double.doubleToLongBits(other.withdraw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("###.#");
		return "BankUser [username= " + username + ", password= " + password + ", balance= $" + df.format(balance) + "]";
	}

}
