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
		// TODO Auto-generated method stub
		System.out.println("ACCOUNT LOGIN\n");
		System.out.println("Please enter your Username: ");
		String username = bank.scan.nextLine();
		System.out.println("Please enter your Password: ");
		String password = bank.scan.nextLine();

		User current = bank.checkIfExists(username, password);
		
		if (current != null) {
			System.out.println("Welcome to your Account.\n");
			return new UserAccountScreen(bank, current);
		} else {
			System.out.println("You do not have a Revature Banking account. Please register.\n");
			return new RegisterScreen(bank);
		}

	}

}
