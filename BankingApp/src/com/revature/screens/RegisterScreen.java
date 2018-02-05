package com.revature.screens;

import com.revature.beans.Account;
import com.revature.beans.Bank;

public class RegisterScreen implements Screen {

	public RegisterScreen(Bank bank) {
		super();
		this.bank = bank;
		
	}

	private Bank bank;

	

	@Override
	public Screen prompt() {
		// TODO Auto-generated method stub
		System.out.println("ACCOUNT REGISTRATION ");
		System.out.println("Please enter your Username: ");
		String username = this.bank.scan.nextLine();
		System.out.println("Please enter your Password: ");
		String password = this.bank.scan.nextLine();
	
		if (!this.bank.checkIfExists(username)) {
			Account current = new Account(username, password, 0);
			this.bank.register(current);
			System.out.println("Congratulations, your account has been created.");
			return new UserAccountScreen(this.bank, current);
			
		} else {
			System.out.println("Account already exists. Please pick a different Username.");
			return new RegisterScreen(this.bank);
		}

	}

}
