package com.revature.bankapp;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Bank user class which holds the personal info of each user account in our
 * bank.
 * 
 * @author Rick
 *
 */
public class BankUser {

	private String username;
	private String password;
	private double balance;
	private double deposit;
	private double withdraw;
	private ArrayList<String> transactions = new ArrayList<String>();

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
	public String toString() {
		DecimalFormat df = new DecimalFormat("###.#");
		return "BankUser [username= " + username + ", password= " + password + ", balance= $" + df.format(balance)
				+ "]";
	}

}
