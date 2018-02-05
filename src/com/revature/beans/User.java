package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * user class, describes an instance of a user
 * @author Matt
 *
 */
public class User implements Serializable, Comparable<User>{
	

	private static final long serialVersionUID = -8407461904514315772L;
	/**
	 * 
	 */
	
	private String username;
	private String password;
	private double balance;
	private ArrayList<Transaction> history;
	
	
	public User(String username, String password, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.history = new ArrayList<>();
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
	public ArrayList<Transaction> getHistory(){
		return history;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
	@Override
	public int compareTo(User other) {
		return other.getUsername().compareTo(username);
	}
	public void addTransaction(Transaction t) {
		history.add(t);
	}
	
}
