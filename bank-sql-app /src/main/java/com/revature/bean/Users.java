package com.revature.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;


public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -805678438218598829L;
	private String username;
	private String password;
	private int userId;

	ArrayList<Transactions> statements;
	


	
	public Users(String username, String password, int userId) {
		super();
		this.username = username;
		this.password = password;
		this.userId = userId;

	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		

		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((statements == null) ? 0 : statements.hashCode());
		result = prime * result + userId;
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
		Users other = (Users) obj;
		
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (statements == null) {
			if (other.statements != null)
				return false;
		} else if (!statements.equals(other.statements))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
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


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public ArrayList<Transactions> getStatements() {
		return statements;
	}


	public void setStatements(ArrayList<Transactions> statements) {
		this.statements = statements;
	}


	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}


	public void deposit(int depositAmount) {
		// TODO Auto-generated method stub
		
	}


	public void addTransaction(int depositAmount, String info) {
		// TODO Auto-generated method stub
		Date todaysDate = (Date) Calendar.getInstance().getTime();
		Transactions trans = new Transactions(depositAmount, info, todaysDate );
	}

	public void displayTransactions() {
		for (int i = 0; i < this.statements.size(); i++) {
			Transactions trans = this.statements.get(i) ;
			System.out.println(trans.amount + "was" + trans.getInfo() + "by " + this.username + "on "  + 
			trans.getDate());
			
		}
	}
	

}
