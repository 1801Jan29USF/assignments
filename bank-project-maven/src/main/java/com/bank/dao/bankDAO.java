package com.bank.dao;

import java.util.List;

import com.bank.beans.AuthUser;

public interface bankDAO {

	
	int addUser(AuthUser m);
	void login(String username, String pass);
	void deposit(int uid, double dinput);
	void withdraw(int uid, double dinput);
	double getUserBal(int id);
	int getCurrentUserID();
	void setCurrentUserID(int i);
	void getUserHistory(int id);

}
