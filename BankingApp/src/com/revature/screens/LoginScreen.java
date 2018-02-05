package com.revature.screens;
import com.revature.beans.Account;
import com.revature.beans.Bank;

public class LoginScreen implements Screen {
	
	public LoginScreen(Bank bank) {
		super();
		this.bank = bank;
	}

	private Bank bank;

	
	@Override
	public Screen prompt() {
		// TODO Auto-generated method stub
		System.out.println("ACCOUNT LOGIN");
		System.out.println("Please enter your Username: ");
		String username = this.bank.scan.nextLine();
		System.out.println("Please enter your Password: ");
		String password = this.bank.scan.nextLine();
		
		Account current = this.bank.checkIfExists(username, password);
		
		if (current != null) {
			System.out.println("Welcome to your Account.");
			return new UserAccountScreen(this.bank, current);
		} else {
			System.out.println("You do not have a Revature Banking account. Please register.");
			return new RegisterScreen(this.bank);
		}

	}

}
