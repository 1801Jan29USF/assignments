package com.revature.screens;

import com.revature.beans.Bank;

public class MainMenu implements Screen {

	public MainMenu(Bank bank) {
		super();
		prompt(bank);
	}

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("PLEASE SELECT AN OPTION: \n");
		System.out.println("Enter 1 to Login");
		System.out.println("Enter 2 to Register\n");
		String input = bank.scan.nextLine();

		switch (input) {
		
		case "1":
			return new LoginScreen(bank);
		case "2":
			return new RegisterScreen(bank);
		default:
			System.out.println("invalid option\n");
			break;
		}
		return new MainMenu(bank);
	}
}
