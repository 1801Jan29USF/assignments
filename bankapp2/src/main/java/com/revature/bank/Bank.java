package com.revature.bank;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Date;

import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.util.BankJDBC;
/**
 * bank object- singleton, manages program functionality
 * @author Matt
 *
 */
public class Bank {
	

	private User currentUser = null;
	private  BankJDBC dao = new BankJDBC();
	private static Bank b = new Bank();

	
	
	
	private Bank(){
		super();
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User user) {
		this.currentUser = user;
	}
	
	public static Bank getBank() {
		return b;
	}
	
	public void addUser(User u) {
		dao.save(u);
	}
	
	public void deposit(User user, double dep) {
		user.setBalance(user.getBalance() + dep);
		dao.update(user, dep);
	}
	public void withdraw(User user, double wit) {
		
		if(user.getBalance() > wit) {
			user.setBalance(user.getBalance() - wit);
			dao.update(user, -wit);
		} else {
			System.out.println("Insufficient funds");
		}
	}
	public User validateLogin(String username, String password) {
		return dao.getUser(username, password);
	}
	public void getTransactions(String username) {
		dao.getTransactions(username);
	}
}
