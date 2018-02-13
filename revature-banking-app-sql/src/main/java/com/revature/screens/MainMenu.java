package com.revature.screens;

import java.util.Scanner;

public class MainMenu implements Screen {
	
	/*******************************************************************************
	  Class Fields
	********************************************************************************/
	
	public Scanner scan = new Scanner(System.in);

	/*******************************************************************************
	  Constructor
	********************************************************************************/
	
	public MainMenu() {
		super();
		prompt();
	}

	/*******************************************************************************
	  Screen Prompt Method
	********************************************************************************/
	
	public Screen prompt() {
		System.out.println("PLEASE SELECT AN OPTION: \n");
		System.out.println("Enter 1 to Login");
		System.out.println("Enter 2 to Register\n");
		String input = scan.nextLine();

		switch (input) {

		case "1":
			return new LoginScreen();
		 case "2":
		 return new RegisterScreen();
		default:
			System.out.println("invalid option\n");
			break;
		}
		return new MainMenu();
	}

}
