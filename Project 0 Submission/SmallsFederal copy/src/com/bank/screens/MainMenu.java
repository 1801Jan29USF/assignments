package com.bank.screens;

import java.util.Scanner;

import com.bank.beans.User;
import com.bank.file.io.UserSerializer;

public class MainMenu implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserSerializer us = new UserSerializer();
	
	@Override
	public Screen prompt() {
		
		System.out.println("Welcome to Smalls Federal Credit Union");
		System.out.println();
		System.out.println("Please select an option: ");
		System.out.println("Enter 1 to Log in to account");
		System.out.println("Enter 2 to create a new account");
		System.out.println();
		String input = scan.nextLine();
		
		switch(input) {
		case "1": 
			return new LoginScreen();
			
		case "2": 
			return new addUserScreen();
			
		default:
			System.out.println("invalid option");
			System.out.println();
			break;
		}
		return new MainMenu();
	}	
}
