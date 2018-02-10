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

	private String password;	

	public int checking;

	public int savings;
	
	public int userId;
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", checking=" + checking + ", savings="
				+ savings + "]";
	}

	List<String> transactions = new ArrayList<>(0);
	
	public int getId() {
		return userId;
	}
	
	public void setId(int id) {
		userId = id;
	}

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

	public User(int id, String u, String p, int c, int s) {
		super();
		this.username = u;
		this.password = p;
		this.checking = 0;
		this.savings = 0;
		this.userId = id;
	}

}
