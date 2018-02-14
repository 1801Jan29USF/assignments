package com.revature.DAO;

import java.util.List;

import com.revature.beans.User;

public interface BankDAO {
	int register(User u);
	boolean exists(String username);
	boolean updateBalance(User u);
	float viewBalance(User u);
	boolean delete(User u);
	User getUser(String username);
	List<String> getHistory(User u);
}
