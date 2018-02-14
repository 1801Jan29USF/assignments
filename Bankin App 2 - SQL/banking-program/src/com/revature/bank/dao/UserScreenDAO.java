package com.revature.bank.dao;

import com.revature.bank.bean.User;

public interface UserScreenDAO {
	
	
	void deposit(String username, double amountD);
	void withdaw(String username, double amountW);
	double viewBalance(String username);

}
