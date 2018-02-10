package com.revature.screens;

import com.revature.beans.Bank;
import com.revature.beans.User;

//allows user to change his username and password
public class ChangeUserAndPassScreen implements Screen {

	private User curr;

	public ChangeUserAndPassScreen(Bank bank, User c) {
		super();
		this.curr = c;
		prompt(bank);
	}

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("ACCOUNT/PASSWORD CHANGE\n");
		System.out.println("Please enter your new Username: \n");
		String username = bank.scan.nextLine();
		System.out.println("Please enter your new Password: \n");
		String password = bank.scan.nextLine();
		if (username.hashCode() == curr.getUsername().hashCode()) {
			System.out.println("That is your current username. Please pick another.\n");
			return new ChangeUserAndPassScreen(bank, curr);
		}
		// If new account name doesn't exist change it
		if (!bank.checkIfExists(username)) {
			System.out.println("Your username and password have been updated.\n");
			bank.updateUserPass(curr, username, password);
			return new UserAccountScreen(bank, curr);
		}
		return new UserAccountScreen(bank, curr);
	}
}
