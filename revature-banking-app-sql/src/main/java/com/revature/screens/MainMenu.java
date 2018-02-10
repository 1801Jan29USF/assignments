package com.revature.screens;

import java.util.Scanner;

public class MainMenu implements Screen {

	public Scanner scan = new Scanner(System.in);

	public MainMenu() {
		super();
		prompt();
	}

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
