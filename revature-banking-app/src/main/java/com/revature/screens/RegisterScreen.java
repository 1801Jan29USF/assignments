package com.revature.screens;

import com.revature.beans.Bank;
import com.revature.beans.User;

public class RegisterScreen implements Screen {

	public RegisterScreen(Bank bank) {
		super();
		prompt(bank);

	}

	@Override
	public Screen prompt(Bank bank) {

		System.out.println("ACCOUNT REGISTRATION \n");
		//added exit functionality in last minute, not the best style :(
		System.out.println("Please enter your Username or enter exit to return to Main Menu.\n");
		String input = bank.scan.nextLine();
		if (input.hashCode() == "exit".hashCode()) {
			return new MainMenu(bank);
		}
		System.out.println("Please enter your Password: ");
		String password = bank.scan.nextLine();

		if (!bank.checkIfExists(input)) {
			User current = new User(input, password);
			bank.register(current);
			System.out.println("Congratulations, your account has been created.\n");
			return new UserAccountScreen(bank, current);

		} else {
			System.out.println("Account already exists. Please pick a different Username.\n");
			return new MainMenu(bank);
		}

	}

}
