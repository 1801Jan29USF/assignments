package com.revature.screens;

import com.revature.beans.Bank;
import com.revature.beans.User;

public class UserAccountScreen implements Screen {

	private User curr;

	public UserAccountScreen(Bank bank, User curr) {
		super();
		this.curr = curr;
		prompt(bank);
	}

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("How can we help you?\n");
		System.out.println("Press 1 for Deposit: ");
		System.out.println("Press 2 for Withdrawal: ");
		System.out.println("Press 3 to View Account Balance: ");
		System.out.println("Press 4 to View Transaction History: ");
		System.out.println("Press 5 to QuickPay");
		System.out.println("Press 6 to Transfer Money from Checking to Savings");
		System.out.println("Press 7 to Change Your User Name And Password");
		System.out.println("Press 8 to Logout");
		String input = bank.scan.nextLine();

		switch (input) {

		case "1":
			return new DepositScreen(bank, curr);
		case "2":
			return new WithdrawalScreen(bank, curr);
		case "3":
			return new ViewBalanceScreen(bank, curr);
		case "4":
			bank.printTrans(curr);
			break;
		case "5":
			return new QuickPayScreen(bank, curr);
		case "6":
			return new TransferScreen(bank, curr);
		case "7":
			return new ChangeUserAndPassScreen(bank, curr);
		case "8":
			bank.users = bank.us.DeserializeUsers("Users.txt");
			return new MainMenu(bank);
		default:
			System.out.println("invalid option\n");
			break;
		}
		return new UserAccountScreen(bank, curr);
	}
}