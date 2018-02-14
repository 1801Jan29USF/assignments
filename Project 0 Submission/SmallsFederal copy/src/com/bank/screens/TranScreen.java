package com.bank.screens;

import com.bank.beans.User;

public class TranScreen extends LoginScreen {

	public User u = new User();
	
	public TranScreen(User u) {
		super();
		this.u = u;
	}
	
	public Screen prompt() {
		
		Trans();
		
		return new AccountScreen(u);
	}
	
	private void Trans() {
		getLog(u.getUserName());
	}

}
