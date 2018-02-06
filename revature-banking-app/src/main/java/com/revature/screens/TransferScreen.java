package com.revature.screens;

import com.revature.beans.Bank;
import com.revature.beans.User;

public class TransferScreen implements Screen {

	private User curr;

	public TransferScreen(Bank bank, User curr) {
		super();
		this.curr = curr;
		prompt(bank);
	}

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("TRANSFER \n");
		System.out.println("Enter amount for transfer");
		int transferAmt = 0;
		try {
			transferAmt = Integer.parseInt(bank.scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input for transfer\n");
			return new UserAccountScreen(bank, curr);
		}
		if (transferAmt < 0) {
			System.out.println("Transfer amount must be greater or equal to 0\n");
			return new UserAccountScreen(bank, curr);
		}
		bank.transfer(curr, transferAmt);
		return new UserAccountScreen(bank, curr);
	}

}
