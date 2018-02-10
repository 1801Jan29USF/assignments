package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 129762462802621867L;

	private String username;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", checking=" + checking + ", savings="
				+ savings + "]";
	}

	private String password;	

	public int checking;

	public int savings;

	List<String> transactions = new ArrayList<>(0);

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setUsername(String u) {
		this.username = u;
	}

	public void setPassword(String p) {
		this.password = p;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.checking = 0;
		this.savings = 0;
	}

}
