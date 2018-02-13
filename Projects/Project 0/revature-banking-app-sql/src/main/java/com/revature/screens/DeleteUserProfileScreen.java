package com.revature.screens;

import java.util.Scanner;

import com.revature.bankinglauncher.PrintOracle;
import com.revature.beans.User;
import com.revature.dao.TransactionsDAOJDBC;

public class DeleteUserProfileScreen implements Screen {
	
	/*******************************************************************************
	  Class Fields
	********************************************************************************/

	public Scanner scan = new Scanner(System.in);

	public TransactionsDAOJDBC dao = new TransactionsDAOJDBC();

	private User curr;
	
	/*******************************************************************************
	 Constructor
	********************************************************************************/
	
	public DeleteUserProfileScreen(User curr) {
		super();
		this.curr = curr;
		prompt();
	}
	
	/*******************************************************************************
	  Screen Prompt Method
	********************************************************************************/
	
	@Override
	public Screen prompt() {
		System.out.println("ACCOUNT DELETION \n");
		System.out.println("Are you sure you want to delete you user profile? (yes or no)\n");
		String answer = scan.nextLine();
		if (answer.equals("yes")) {
			dao.deleteUserProfile(curr.getId());
			System.out.println("Your profile has been deleted. We are sad to see you go :(\n");
		}
		else {
			return new UserAccountScreen(curr);
		}
		PrintOracle p = new PrintOracle();
		p.printTitle();
		return new MainMenu();
	}

}
