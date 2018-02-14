package com.revature.bank.dao;

import com.revature.bank.bean.User;

public interface AddUserDAO {
	int addUser(String username, String password, Double balance);
	User checkIfUser(String username);
	User checkIfPassword(String pasword);

}
