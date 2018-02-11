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
		System.out.println("Press s for Savings");
		System.out.println("Press c for Checking");
		String type = scan.nextLine();
		if (!((type.hashCode() == "s".hashCode()) || (type.hashCode() == "c".hashCode()))) {
			System.out.println("Invalid account option\n");
			return new UserAccountScreen(curr);
		}
		dao.balance(curr.userId, type);
		return new UserAccountScreen(curr);
	}

}
