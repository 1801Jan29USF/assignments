package com.revature.dao;

import com.revature.beans.User;

public interface BankDAO {
	int save(User u);

	User login(String input, String password);

	User register(String u, String p);
	
	void deposit(int id, int amt, String type);
	
	void withdraw(int id, int amt);

}
