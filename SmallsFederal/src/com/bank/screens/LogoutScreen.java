package com.bank.screens;

import com.bank.beans.User;
import com.bank.file.io.UserSerializer;

public class LogoutScreen extends LoginScreen {
	
	private UserSerializer us = new UserSerializer();

	@Override
	public Screen prompt() {
		// TODO Auto-generated method stub
		Logout();
		
		return new MainMenu();
	}
	
	private void Logout() {
		us.SerializeUser(u, u.getUserName() + ".txt");
		System.out.println();
		System.out.println("Thank You for Banking with Smalls Federal");
		System.out.println();
	}
}
