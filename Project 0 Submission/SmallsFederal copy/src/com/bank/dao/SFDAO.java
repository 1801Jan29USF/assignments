package com.bank.dao;

import java.util.List;

import com.bank.beans.User;

public interface SFDAO {
	
	// C
	int save(User u);
	
	// R
	User get(String username, String password);
	
	// U
	void update(User u);
	
	// D
	void delete(User u);

}
