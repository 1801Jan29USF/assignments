package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.AccountDAOJDBC;

public class DeleteAccountScreen implements Screen {

	public Scanner scan = new Scanner(System.in);

	public AccountDAOJDBC dao = new AccountDAOJDBC();

	private User curr;

	public DeleteAccountScreen(User curr) {
		super();
		this.curr = curr;
		prompt();
	}

	@Override
	public Screen prompt() {
		System.out.println("ACCOUNT DELETION \n");
		System.out.println("Which account would you like to delete?\n");
		String acctName = scan.nextLine();
		dao.deleteAccount(curr.getId(), acctName);
		return new UserAccountScreen(curr);
	}
}
