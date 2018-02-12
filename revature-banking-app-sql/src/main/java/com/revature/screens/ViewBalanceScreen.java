package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

public class ViewBalanceScreen implements Screen {

	public Scanner scan = new Scanner(System.in);

	public BankDAOJDBC dao = new BankDAOJDBC();

	public ViewBalanceScreen(User curr) {
		super();
		this.curr = curr;
		prompt();
	}

	private User curr;

	@Override
	public Screen prompt() {
		System.out.println("VIEW BALANCE \n");
		System.out.println("Enter the account name that you wish to see the balance of.\n");
		String name = scan.nextLine();
		System.out.println("Your balance is " + dao.balance(curr.userId, name) + "$\n");
		return new UserAccountScreen(curr);
	}

}
