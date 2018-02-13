package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.TransactionsDAOJDBC;

public class LoginScreen implements Screen {
	
	/*******************************************************************************
	  Class Fields
	********************************************************************************/

	public Scanner scan = new Scanner(System.in);
	public TransactionsDAOJDBC dao = new TransactionsDAOJDBC();
	
	/*******************************************************************************
	  Class Constructor
	********************************************************************************/

	public LoginScreen() {
		super();
		prompt();
	}

	/*******************************************************************************
	  Screen Prompt Method
	********************************************************************************/
	
	@Override
	public Screen prompt() {
		System.out.println("ACCOUNT LOGIN\n");
		System.out.println("Please enter your Username or exit to return to Main Menu: ");
		String input = scan.nextLine();
		if (input.equals("exit")) {
			return new MainMenu();
		}
		System.out.println("Please enter your Password: ");
		String password = scan.nextLine();

		User current = dao.login(input, password);

		if (current != null) {
			System.out.println("Welcome to your Account.\n");
			return new UserAccountScreen(current);
		} else {
			System.out.println("You do not have an ORACLE BANKING account. Please register. \n");
			return new RegisterScreen();
		}
	}

}
