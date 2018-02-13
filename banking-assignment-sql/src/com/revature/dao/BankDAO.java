package com.revature.dao;

import java.util.List;

import com.revature.beans.Transaction;
import com.revature.beans.User;

public interface BankDAO {
	void addUser(User u);
	void addUserWithUsername(User u, String userName);
	void addTransaction(User u, Transaction t);
	
	void update(User u);
	void withdraw(User u, double amount);
	void deposit(User u, double amount);
	
	User getUser(String userName);
	List<Transaction> getTransactions(int id);
}