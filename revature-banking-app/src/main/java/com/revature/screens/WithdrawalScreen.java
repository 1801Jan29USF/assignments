package com.revature.screens;

import com.revature.beans.Bank;
import com.revature.beans.User;

public class WithdrawalScreen implements Screen {

	private User curr;
	
	public WithdrawalScreen(Bank bank, User curr) {
		super();
		this.curr = curr;
		prompt(bank);
	}

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("WITHDRAWAL \n");
		System.out.println("Please Enter Amount for Withdrawal: ");
		int withdrawAmt = 0;
		try {
			withdrawAmt = Integer.parseInt(bank.scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input for withdrawal\n");
			return new UserAccountScreen(bank, curr);
		}
		if (withdrawAmt < 0) {
			System.out.println("Withdrawal amount must be greater or equal to 0\n");
			return new UserAccountScreen(bank, curr);
		}
		bank.withdraw(curr, withdrawAmt);
		return new UserAccountScreen(bank, curr);
	}
}
