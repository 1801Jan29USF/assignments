package com.revature.BankingApplication;



public interface BankingDAO {

	int Register(UserStorage us);
	UserStorage get(String username, String password);
	void Update(UserStorage us);
	void getTransaction(String username);
}
