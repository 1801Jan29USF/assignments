package com.revature.screens;

import com.revature.beans.Bank;
import com.revature.beans.User;

public class LoginScreen implements Screen {

	public LoginScreen(Bank bank) {
		super();
		prompt(bank);
	}

	@Override
	public Screen prompt(Bank bank) {

		System.out.println("ACCOUNT LOGIN\n");
		System.out.println("Please enter your Username or exit to return to Main Menu: ");
		String input = bank.scan.nextLine();
		//Added exit functionality in last minute, not the best style :(
		if (input.hashCode() == "exit".hashCode()) {
			return new MainMenu(bank);
		}
		System.out.println("Please enter your Password: ");
		String password = bank.scan.nextLine();

		User current = bank.checkIfExists(input, password);

		if (current != null) {
			System.out.println("Welcome to your Account.\n");
			return new UserAccountScreen(bank, current);
		} else {
			System.out.println("You do not have a Revature Banking account. Please register.");
			return new RegisterScreen(bank);
		}

	}

}
