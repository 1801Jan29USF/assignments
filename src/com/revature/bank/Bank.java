package com.revature.bank;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Date;

import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.util.SerializeUser;
/**
 * bank object- singleton, manages program functionality
 * @author Matt
 *
 */
public class Bank {
	

	private ArrayList<User> userList = new ArrayList<>();
	private SerializeUser su = new SerializeUser();
	private User currentUser = null;
	private static Bank b = new Bank();
	
	
	
	private Bank(){
		super();
		this.addUser(new User("test", "pass", 0));
		userList = su.deserializeList("users.txt"); 
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
		if(!userList.contains(u)) {
			userList.add(u);
		}
		su.serializeList(userList, "users.txt");
	}
	
	public void deposit(User user, double dep) {
		user.setBalance(user.getBalance() + dep);
		user.addTransaction(new Transaction(dep));
		System.out.println("Success");
		su.serializeList(userList, "users.txt");
	}
	public void withdraw(User user, double wit) {
		
		if(user.getBalance() > wit) {
			user.setBalance(user.getBalance() - wit);
			user.addTransaction(new Transaction(-wit));
			System.out.println("Success");
			su.serializeList(userList, "users.txt");
		} else {
			System.out.println("Insufficient funds");
		}
	}
	public User validateLogin(String username, String password) {
		for (User user : userList) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				System.out.println("Success");
				return user;
			}
		}
		System.out.println("Username or password did not match our records. Please try again.");
		return null;
	}
}
