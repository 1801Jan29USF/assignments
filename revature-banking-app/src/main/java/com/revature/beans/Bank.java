package com.revature.beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.util.AccountsSerializer;

public class Bank implements Serializable {

	private static final long serialVersionUID = 4558957633562884310L;

	private ArrayList<User> users = new ArrayList<>(0);

	public AccountsSerializer us = new AccountsSerializer();

	transient public Scanner scan = new Scanner(System.in);

	transient private static Logger log = Logger.getRootLogger();

	transient public DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH::mm::ss");

	transient public Date date = new Date();

	private static Bank b = new Bank();

	private Bank() {

	}

	public static Bank getBank() {
		return b;
	}

	public void deposit(User u, int amount, String type) {
		if (type == "c") {
			u.checking = u.checking + amount;
			us.SerializeUsers(this.users, "Users.txt");
			u.transactions.add(dateFormat.format(date) + "	Deposited " + amount + "$ to checking");
			log.info(u.toString() + " deposited " + amount + "$ to checking");
		} else {
			u.savings = u.savings + amount;
			us.SerializeUsers(this.users, "Users.txt");
			u.transactions.add(dateFormat.format(date) + "	Deposited " + amount + "$ to savings");
			log.info(u.toString() + " deposited " + amount + "$ to savings");
		}
	}

	public void withdraw(User a, int amount) {
		if (a.checking - amount < 0) {
			System.out.println("Insufficient funds in Checking acct");
			log.info(a.toString() + " attempted to withdraw " + amount + "$ but their account had insufficient funds");
			return;
		}
		a.checking = a.checking - amount;
		us.SerializeUsers(this.users, "Accounts.txt");
		a.transactions.add(dateFormat.format(date) + "	Withdrew " + amount + "$ from Checking Account");
		log.info(a.toString() + " withdrew " + amount + "$ from Checking Account");
	}
	
	public void transfer(User a, int amount) {
		if (a.checking - amount < 0) {
			System.out.println("Insufficient funds in Checking acct. Cannot complete transfer");
			log.info(a.toString() + " attempted to transfer " + amount + "$ but their account had insufficient funds");
			return;
		}
		a.checking -=amount;
		a.savings += amount;
	}

	public void balance(User u, String type) {
		if (type == "c") {
			System.out.println(u.checking);
		}
		else {
			System.out.println(u.savings);
		}
	}
	
	

	// loops through accounts and checks is account
	// already exists. if so, returns account object
	// if not returns null. (Login)
	public User checkIfExists(String username, String password) {
		// check to see if account already exists
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i).getUsername().hashCode() == username.hashCode()
					&& users.get(i).getPassword().hashCode() == password.hashCode()) {
				return users.get(i);
			}
		}
		return null;
	}

	// loops through accounts and checks is account
	// already exists. if so, returns account object
	// if not returns null. (Registration)
	public boolean checkIfExists(String username) {
		boolean exists = false;
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i).getUsername().hashCode() == username.hashCode()) {
				exists = true;
			}
		}
		return exists;
	}

	public void register(User u) {
		this.users.add(u);
		us.SerializeUsers(this.users, "Users.txt");
		log.info(u.toString() + " added");
	}

	public void quickPayDeposit(User receiver, User sender, int amount) {
		receiver.checking += receiver.checking + amount;
		us.SerializeUsers(this.users, "Users.txt");
		receiver.transactions.add(dateFormat.format(date) + sender.getUsername() + "	Quickpayed you " + amount + "$");
		sender.transactions.add(dateFormat.format(date) + "	Quickpayed " + amount + "$ to " + receiver.getUsername());
		log.info(sender.toString() + " quickpayed " + amount + "$ to " + receiver.getUsername());
	}

	public void quickPay(String receiver, User sender, int amount) {

		for (User user : this.users) {
			if (receiver.hashCode() == user.getUsername().hashCode()) {
				this.quickPayDeposit(user, sender, amount);
			}
		}
	}
}
