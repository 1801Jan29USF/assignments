package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import com.revature.util.AccountsSerializer;


public class Bank implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4558957633562884310L;

	private ArrayList<Account> accounts;
	
	public AccountsSerializer as = new AccountsSerializer();
	
	transient public Scanner scan = new Scanner(System.in);

	public Bank(ArrayList<Account> accounts) {
		super();
		this.accounts = accounts;
	}

	public void deposit(Account a, int amount) {
		a.setBalance(a.getBalance() + amount);
		as.SerializeAccounts(this.accounts, "Accounts.txt");
	}

	public void withdraw(Account a, int amount) {
		if (a.getBalance() - amount < 0) {
			System.out.println("Insufficient funds");
			return;
		}
		a.setBalance(a.getBalance() - amount);
		as.SerializeAccounts(this.accounts, "Accounts.txt");
	}

	public void viewBalance(Account a) {
		System.out.println(a.getBalance());
	}

	// loops through accounts and checks is account
	// already exists. if so, returns account object
	// if not returns null. (Login)
	public Account checkIfExists(String username, String password) {
		// check to see if account already exists
		for (int i = 0; i < this.accounts.size(); i++) {
			if (accounts.get(i).getUsername().hashCode() == username.hashCode()
					&& accounts.get(i).getPassword().hashCode() == password.hashCode()) {
				return accounts.get(i);
			}
		}
		return null;
	}

	// loops through accounts and checks is account
	// already exists. if so, returns account object
	// if not returns null. (Registration)
	public boolean checkIfExists(String username) {
		boolean exists = false;
		for (int i = 0; i < this.accounts.size(); i++) {
			if (accounts.get(i).getUsername().hashCode() == username.hashCode()) {
				exists = true;
			}
		}
		return exists;
	}

	public void register(Account a) {
		this.accounts.add(a);
		as.SerializeAccounts(this.accounts, "Accounts.txt");
	}
}
