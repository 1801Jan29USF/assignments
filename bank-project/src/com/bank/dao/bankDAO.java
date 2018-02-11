package com.bank.dao;

import com.bank.beans.AuthUser;

public interface bankDAO {
	
	int addUser(AuthUser m);
	
	void deposit(AuthUser m, int amount);
	
	void withdraw(AuthUser m, int amount);
	
	AuthUser getUser(int id);

	
}
