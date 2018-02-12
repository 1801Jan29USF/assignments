package com.revature.dao;

import com.revature.beans.User;

public interface BankDAO {
	int save(User u);

	User login(String input, String password);

	User register(String u, String p);
	
	void deposit(int id, int amt, String acctName);
	
	void withdraw(int id, int amt, String acctName);
	
	int balance(int id, String type);
	
	void transfer(int id , int amt, String acctFrom, String acctTo);

	void quickPay(String acct, String receiver, int id, int amount);
	
	boolean updateUserPass(int id, String username, String password);
	
	void printTrans(int id);
	
	void deleteUserProfile(int id);
}
