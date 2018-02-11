package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

public class DepositScreen implements Screen {

	private User curr;

	public Scanner scan = new Scanner(System.in);
	public BankDAOJDBC dao = new BankDAOJDBC();

	public DepositScreen(User u) {
		super();
		this.curr = u;
		prompt();
	}

	@Override
	public Screen prompt() {
		System.out.println("DEPOSIT \n");
		System.out.println("Please Enter Amount for Deposit: ");
		int depositAmt = 0;
		try {
			depositAmt = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input for deposit\n");
			return new UserAccountScreen(curr);
		}
		if (depositAmt < 0) {
			System.out.println("Deposit amount must be greater or equal to 0\n");
			return new UserAccountScreen(curr);
		}
		System.out.println("Enter savings to deposit " + depositAmt + "$ into you checking account");
		System.out.println("Enter savings to deposit " + depositAmt + "$ into you savings account");
		String type = scan.nextLine();
		if (!((type.hashCode() == "savings".hashCode()) || (type.hashCode() == "checking".hashCode()))) {
			System.out.println("Invalid account option\n");
			return new UserAccountScreen(curr);
		}
		dao.deposit(curr.userId, depositAmt, type);

		return new UserAccountScreen(curr);
	}

}
