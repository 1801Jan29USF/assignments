package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 129762462802621867L;
	
	public String username;

	public String password;	

	public int checking;

	public int savings;

	public ArrayList<String> transactions = new ArrayList<>(0);

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

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.checking = 0;
		this.savings = 0;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	public int getChecking() {
		return checking;
	}

	public void setChecking(int checking) {
		this.checking = checking;
	}

	public int getSavings() {
		return savings;
	}

	public void setSavings(int savings) {
		this.savings = savings;
	}

}
