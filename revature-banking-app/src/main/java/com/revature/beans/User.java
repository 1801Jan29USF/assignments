package com.revature.beans;

import java.util.ArrayList;

public class User {

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

	public User(String username, String password, int c, int s) {
		super();
		this.username = username;
		this.password = password;
		this.checking = c;
		this.savings = s;
	}

	public String username;

	public String password;	

	public int checking;

	public int savings;

	public ArrayList<String> transactions = new ArrayList<>(0);

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
