package com.bank.screens;

import java.util.Scanner;

import com.bank.beans.User;
import com.bank.file.io.UserSerializer;

public class addUserScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserSerializer us = new UserSerializer();
	
	@Override
	public Screen prompt() {
		addUser();
		
		return new MainMenu();
	}
	
	private void addUser() {
		System.out.println("Enter the username you wish to use: ");
		String username = scan.nextLine();
		System.out.println("Enter the password you wish to use :");
		String password = scan.nextLine();
		
		User u = new User(username, password, 0.0);
		us.SerializeUser(u, u.getUserName() + ".txt");
		System.out.println();
		System.out.println("Your account has been created");
		System.out.println();
	}
}
