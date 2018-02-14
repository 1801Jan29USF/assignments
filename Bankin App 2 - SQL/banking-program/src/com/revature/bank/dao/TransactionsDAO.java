package com.revature.bank.dao;

import java.util.List;

import com.revature.bank.bean.User;
import com.revature.bank.bean.UserTranactions;

public interface TransactionsDAO {
	
	
	//void viewTransaction(int id);
	void addTransaction(User username, UserTranactions trans);
	List<UserTranactions> getTransactions(int id);
	

}
