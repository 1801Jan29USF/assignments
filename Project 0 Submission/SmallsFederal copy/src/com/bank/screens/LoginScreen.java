package com.bank.screens;

import java.util.Scanner;

import com.bank.file.io.UserSerializer;
import com.bank.beans.User;
import com.bank.dao.SFDAOJDBC;

public class LoginScreen extends SFDAOJDBC implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserSerializer us = new UserSerializer();
	
	public User u = new User();
	
	@Override
	public Screen prompt() {
		System.out.println("Enter Username: ");
		String username = scan.nextLine();
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		System.out.println();
		
	//	u = us.DeserializeUser(username + ".txt");
		 // u = get(username, password);
		if(get(username, password) == null) {
			System.out.println();
			System.out.println("Username and/or password is invalid");
			System.out.println();
			return new MainMenu();
		}
		else {
		
			return new AccountScreen(get(username, password));
		}
	
	}

}
