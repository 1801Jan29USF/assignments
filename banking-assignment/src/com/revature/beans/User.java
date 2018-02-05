package com.revature.beans;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -179165420429700717L;
	private static User u = new User();
	private String username;
	private String password;
	private int balance;
	
	private User() {
		super();
	}
	
	public static User getUser(String userName, String password, int balance) {
		u.setUsername(userName);
		u.setPassword(password);
		u.setBalance(balance);
		return u;
	}
	
	public static User getUser(String userName, String password) {
		u.setUsername(userName);
		u.setPassword(password);
		return u;
	}
	
	public static User getUser() {
		return u;
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
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (balance != other.balance)
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
		return true;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", balance=" + balance + "]";
	}
}