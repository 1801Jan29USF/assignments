package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

public class QuickPayScreen implements Screen {

	private User curr;

	public Scanner scan = new Scanner(System.in);

	public BankDAOJDBC dao = new BankDAOJDBC();

	public QuickPayScreen(User u) {
		super();
		this.curr = u;
		prompt();
	}

	@Override
	public Screen prompt() {
		System.out.println("QUICKPAY \n");
		System.out.println("Enter The Account Name you would like to send from: ");
		String acct = scan.nextLine();
		System.out.println("Enter Receiver's Account Name: ");
		String receiver = scan.nextLine();
		System.out.println("Enter amount to send: ");
		int amount = 0;
		try {
			amount = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input for Quickpay\n");
		}
		if (amount < 0) {
			System.out.println("Quickpay amount must be greater or equal to 0\n");
		}
		dao.quickPay(acct, receiver, curr.getId(), amount);

		return new UserAccountScreen(curr);
	}

}
