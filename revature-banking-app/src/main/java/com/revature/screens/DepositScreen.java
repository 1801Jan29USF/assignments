package com.revature.screens;

import com.revature.beans.Bank;
import com.revature.beans.User;

public class DepositScreen implements Screen {

	private User curr;

	public DepositScreen(Bank bank, User u) {
		super();
		this.curr = u;
		prompt(bank);
	}

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("DEPOSIT \n");
		System.out.println("Please Enter Amount for Deposit: ");
		int depositAmt = 0;
		try {
			depositAmt = Integer.parseInt(bank.scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input for deposit\n");
			return new UserAccountScreen(bank, curr);
		}
		if (depositAmt < 0) {
			System.out.println("Deposit amount must be greater or equal to 0\n");
			return new UserAccountScreen(bank, curr);
		}
		System.out.println("Press s for Savings");
		System.out.println("Press c for Checking");
		String type = bank.scan.nextLine();
		if (!((type.hashCode() == "s".hashCode()) || (type.hashCode() == "c".hashCode()))) {
			System.out.println("Invalid account option\n");
			return new UserAccountScreen(bank, curr);
		}
		bank.deposit(curr, depositAmt, type);

		return new UserAccountScreen(bank, curr);
	}

}
