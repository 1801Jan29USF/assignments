package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.TransactionsDAOJDBC;

public class RegisterScreen implements Screen {
	
	/*******************************************************************************
	  Class Fields
	********************************************************************************/
	
	public Scanner scan = new Scanner(System.in);
	public TransactionsDAOJDBC dao = new TransactionsDAOJDBC();
	
	/*******************************************************************************
	  Constructor
	********************************************************************************/
	
	public RegisterScreen() {
		super();
		prompt();

	}
	
	/*******************************************************************************
	  Screen Prompt
	********************************************************************************/

	@Override
	public Screen prompt() {
		System.out.println("ACCOUNT REGISTRATION \n");
		System.out.println("Please enter your Username or enter exit to return to Main Menu.");
		String input = scan.nextLine();
		if (input.hashCode() == "exit".hashCode()) {
			return new MainMenu();
		}
		System.out.println("Please enter your Password: ");
		String password = scan.nextLine();
		User current = dao.register(input, password);
		if (current != null) {
			System.out.println("Congratulations, your account has been created.\n");
			return new UserAccountScreen(current);

		} else {
			System.out.println("Account already exists. Please pick a different Username.\n");
			return new MainMenu();
		}

	}

}
