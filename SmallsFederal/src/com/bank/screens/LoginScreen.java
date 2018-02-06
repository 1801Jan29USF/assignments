package com.bank.screens;

import java.util.Scanner;

import com.bank.file.io.UserSerializer;
import com.bank.beans.User;

public class LoginScreen implements Screen {
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
		
		u = us.DeserializeUser(username + ".txt");
		
		if(u.getUserName().equals(username) && u.getPassword().equals(password)) {
			return new AccountScreen(u);
		}
		else {
			System.out.println("Username and/or password is invalid");
			System.out.println();
			return new MainMenu();
		}
	
	}

}
