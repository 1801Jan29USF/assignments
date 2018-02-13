package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.AccountDAOJDBC;

public class CreateAccountScreen implements Screen {
	public Scanner scan = new Scanner(System.in);

	public AccountDAOJDBC dao = new AccountDAOJDBC();

	private User curr;

	public CreateAccountScreen(User c) {
		super();
		this.curr = c;
		prompt();
	}

	@Override
	public Screen prompt() {
		System.out.println("CREATE ACCOUNT \n");
		System.out.println("Enter Name of Account: (*No apostrophes are allowed in account name*)\n");
		String name = scan.nextLine();
		if (name.contains("'")) {
			System.out.println("Your chosen account name contains an apostrophe. Please select an account name that does not contain an apostrophe.\n");
			return new CreateAccountScreen(curr);
		}
		System.out.println("What kind of account would you like to create (checking or savings)?");
		String type = scan.nextLine();
		if (!((type.hashCode() == "savings".hashCode()) || (type.hashCode() == "checking".hashCode()))) {
			System.out.println("Invalid account option\n");
			return new CreateAccountScreen(curr);
		}
		dao.createAccount(curr.getId(), name, type);
		return new UserAccountScreen(curr);
	}
}
