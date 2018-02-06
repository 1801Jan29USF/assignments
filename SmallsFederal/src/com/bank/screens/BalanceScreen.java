package com.bank.screens;

import com.bank.beans.User;
import com.bank.file.io.UserSerializer;

public class BalanceScreen extends LoginScreen {
	
	public User u = new User();
	
	private UserSerializer us = new UserSerializer();
	
	public BalanceScreen(User u) {
		super();
		this.u = u;
	}
	
	public Screen prompt() {
		
		System.out.println();
		System.out.println("Your available account balance is: " + u.getBalance());
		us.SerializeUser(u, u.getUserName() + ".txt");
		System.out.println();
		
		return new AccountScreen(u);
	}
}
