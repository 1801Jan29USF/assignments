package com.bank.dao;

import java.util.*;
import java.util.logging.Logger;

import com.bank.beans.AuthUser;

public class BankDAOJDBC implements bankDAO {
	
	private Logger log = Logger.getAnonymousLogger();
	
	private AuthUser current;

	@Override
	public int addUser(AuthUser m) {
		
		return 0;
	}

	@Override
	public void deposit(AuthUser m, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void withdraw(AuthUser m, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public AuthUser getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
