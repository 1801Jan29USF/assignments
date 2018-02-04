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
		// TODO Auto-generated method stub
		System.out.println("ACCOUNT REGISTRATION \n");
		System.out.println("Please enter your Username: ");
		String username = bank.scan.nextLine();
		System.out.println("Please enter your Password: ");
		String password = bank.scan.nextLine();
	
		if (!bank.checkIfExists(username)) {
			User current = new User(username, password);
			bank.register(current);
			System.out.println("Congratulations, your account has been created.\n");
			return new UserAccountScreen(bank, current);
			
		} else {
			System.out.println("Account already exists. Please pick a different Username.\n");
			return new RegisterScreen(bank);
		}

	}

}
