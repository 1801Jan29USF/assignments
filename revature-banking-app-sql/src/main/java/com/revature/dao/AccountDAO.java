package com.revature.dao;

public interface AccountDAO {
	
	void createAccount(int id, String name, String type);

	void deleteAccount(int id, String acctName);
}
