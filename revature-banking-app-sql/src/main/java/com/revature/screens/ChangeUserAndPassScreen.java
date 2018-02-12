package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

//allows user to change his username and password
public class ChangeUserAndPassScreen implements Screen {

	private User curr;
	
	public Scanner scan = new Scanner(System.in);

	public BankDAOJDBC dao = new BankDAOJDBC();

	public ChangeUserAndPassScreen(User c) {
		super();
		this.curr = c;
		prompt();
	}

	@Override
	public Screen prompt() {
		System.out.println("ACCOUNT/PASSWORD CHANGE\n");
		System.out.println("Please enter your new Username: \n");
		String username = scan.nextLine();
		System.out.println("Please enter your new Password: \n");
		String password = scan.nextLine();
		if (username.hashCode() == curr.getUsername().hashCode()) {
			System.out.println("That is your current username. Please pick another.\n");
			return new ChangeUserAndPassScreen(curr);
		}
		// If new account name doesn't exist change it
		if (dao.updateUserPass(curr.getId(), username, password)) {
			System.out.println("Your username and password have been updated.\n");
			curr.setUsername(username);
			curr.setPassword(password);
			return new UserAccountScreen(curr);
		}
		System.out.println("Chosen username already exists. Please choose a new usename.\n");
		return new UserAccountScreen(curr);
	}
}
