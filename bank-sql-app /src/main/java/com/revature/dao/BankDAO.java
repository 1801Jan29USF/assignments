package com.revature.dao;

import com.revature.bean.Users;

public interface BankDAO {
	
	Users signup (String username, String password);
	
	Users login (String username, String password);
	
	int insert(Users user) ;
	void deposit (int amount, String username, int user_id);
	void withdraw (String username, int withdawAmount);
	int viewBalance (int userId, String info);
	void displayTransaction(int userId);

	

}
