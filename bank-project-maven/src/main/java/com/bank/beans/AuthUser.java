package com.bank.beans;

import java.io.Serializable;

/**
 * AuthUser or "Authenticated User" extends User, which ended up being an
 * unecessary inheritance since User didn't have anything. Still, if this
 * program had a larger scope, AuthUser might differ from other types of users
 * like Admins and Employees not necessary for this project. Some methods like
 * login and logout were unused
 *
 */
public class AuthUser extends User {

	/**
	 * 
	 */
	protected int uid;
	protected String username;
	protected String password;

	public AuthUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	private double balance;

	public AuthUser(int uid, String username, String password, double balance) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	@Override
	void login() {
		// TODO Auto-generated method stub

	}

	void logout() {
		// TODO Auto-generated method stub

	}

	// toString does not include the password for 'security!'
	@Override
	public String toString() {
		return "AuthUser [uid=" + uid + ", username=" + username + ", balance=" + balance + "]";
	}

}
