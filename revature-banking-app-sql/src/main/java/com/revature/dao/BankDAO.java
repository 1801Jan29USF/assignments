package com.revature.dao;

import com.revature.beans.User;

public interface BankDAO {
	int save(User u);

	User login(String input, String password);

	User register(String u, String p);
	
	void deposit(int id, int amt, String type);
	
	void withdraw(int id, int amt);
	
	int balance(int id, String type);
	
	void transfer(int id , int amt, String type);

	void quickPay(String receiver, int id, int amount);
	
	boolean updateUserPass(int id, String username, String password);
}
