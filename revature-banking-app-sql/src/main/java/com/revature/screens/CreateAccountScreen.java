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
		System.out.println("Enter name of account? (*No apostrophes are allowed in account name*)\n");
		String name = scan.nextLine();
		if (name.contains("'")) {
			System.out.println("Your chosen account name contains an apostrophe. Please select an account name that does not contain an apostrophe.\n");
			return new CreateAccountScreen(curr);
		}
		System.out.println("Enter savings to create a savings account, or checking to create a checking account)");
		String type = scan.nextLine();
		if (!((type.hashCode() == "savings".hashCode()) || (type.hashCode() == "checking".hashCode()))) {
			System.out.println("Invalid account option\n");
			return new CreateAccountScreen(curr);
		}
		dao.createAccount(curr.getId(), name, type);
		return new UserAccountScreen(curr);
	}
}
