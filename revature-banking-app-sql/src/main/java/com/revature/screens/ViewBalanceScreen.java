package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.TransactionsDAOJDBC;

public class ViewBalanceScreen implements Screen {
	
	/*******************************************************************************
	 * Class Fields
	 ********************************************************************************/

	public Scanner scan = new Scanner(System.in);
	public TransactionsDAOJDBC dao = new TransactionsDAOJDBC();
	private User curr;
	
	/*******************************************************************************
	 * Constructor
	 ********************************************************************************/

	public ViewBalanceScreen(User curr) {
		super();
		this.curr = curr;
		prompt();
	}
	
	/*******************************************************************************
	 * Screen Prompt
	 ********************************************************************************/

	@Override
	public Screen prompt() {
		System.out.println("VIEW BALANCE \n");
		System.out.println("Enter the account name that you wish to see the balance of.\n");
		String name = scan.nextLine();
		System.out.println("Your balance is " + dao.balance(curr.userId, name) + "$\n");
		return new UserAccountScreen(curr);
	}

}
