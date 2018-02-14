package com.revature.bank.dao;

import com.revature.bank.bean.User;

public interface LoginDAO {
	
	User login(String username, String password);

}
