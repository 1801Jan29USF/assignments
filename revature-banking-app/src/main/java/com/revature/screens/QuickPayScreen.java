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
		Integer amount = Integer.parseInt(scan.nextLine());

		bank.quickPay(receiver, curr, amount);

		return new UserAccountScreen(bank, curr);
	}

}
