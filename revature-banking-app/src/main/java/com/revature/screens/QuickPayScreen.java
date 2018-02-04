package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.Bank;
import com.revature.beans.User;

public class QuickPayScreen implements Screen {

	private Scanner scan = new Scanner(System.in);

	private User curr;

	public QuickPayScreen(Bank bank, User u) {
		super();
		this.curr = u;
		prompt(bank);
	}

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("Enter Username of receiver: ");
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
		bank.quickPay(receiver, curr, amount);

		return new UserAccountScreen(bank, curr);
	}

}
