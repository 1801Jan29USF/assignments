package com.revature.screens;

import com.revature.beans.Bank;
import com.revature.beans.User;

public class ViewBalanceScreen implements Screen {

	public ViewBalanceScreen(Bank bank, User curr) {
		super();
		this.curr = curr;
		prompt(bank);
	}

	private User curr;

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("VIEW BALANCE \n");
		System.out.println("Press s for Savings");
		System.out.println("Press c for Checking");
		String type2 = bank.scan.nextLine();
		if (!((type2.hashCode() == "s".hashCode()) || (type2.hashCode() == "c".hashCode()))) {
			System.out.println("Invalid account option\n");
			return new UserAccountScreen(bank, curr);
		}
		bank.balance(curr, type2);
		return new UserAccountScreen(bank, curr);
	}

}
