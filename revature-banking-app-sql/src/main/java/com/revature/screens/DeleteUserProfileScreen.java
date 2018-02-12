package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

public class DeleteUserProfileScreen implements Screen {

	public Scanner scan = new Scanner(System.in);

	public BankDAOJDBC dao = new BankDAOJDBC();

	private User curr;

	public DeleteUserProfileScreen(User curr) {
		super();
		this.curr = curr;
		prompt();
	}

	@Override
	public Screen prompt() {
		System.out.println("ACCOUNT DELETION \n");
		System.out.println("Are you sure you want to delete you user profile?\n");
		String answer = scan.nextLine();
		if (answer.hashCode() == "yes".hashCode()) {
			dao.deleteUserProfile(curr.getId());
		}
		else {
			return new UserAccountScreen(curr);
		}
		return new MainMenu();
	}

}
