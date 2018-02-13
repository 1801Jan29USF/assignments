package com.revature.beans;

public class User {


	private String username;

	private String password;	
	
	public int userId;
	

	
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

	public User(int id, String u, String p) {
		super();
		this.username = u;
		this.password = p;
		this.userId = id;
	}

}
