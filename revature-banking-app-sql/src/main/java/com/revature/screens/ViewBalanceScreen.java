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
		System.out.println("Enter checking to view the balance of your checking account.\n");
		System.out.println("Enter savings to view the balance of your savings account.\n");
		String type = scan.nextLine();
		if (!((type.hashCode() == "savings".hashCode()) || (type.hashCode() == "checking".hashCode()))) {
			System.out.println("Invalid account option\n");
			return new UserAccountScreen(curr);
		}
		System.out.println("Your balance is " + dao.balance(curr.userId, type) + "$\n");
		return new UserAccountScreen(curr);
	}

}
