package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

public class UserAccountScreen implements Screen {

	public Scanner scan = new Scanner(System.in);

	public BankDAOJDBC dao = new BankDAOJDBC();

	private User curr;

	public UserAccountScreen(User c) {
		super();
		this.curr = c;
		prompt();
	}

	@Override
	public Screen prompt() {
		System.out.println("How can we help you?\n");
		System.out.println("Press 1 for Deposit: ");
		System.out.println("Press 2 for Withdrawal: ");
		System.out.println("Press 3 to View Account Balance: ");
		System.out.println("Press 4 to View Transaction History: ");
		System.out.println("Press 5 to QuickPay");
		System.out.println("Press 6 to Transfer Money");
		System.out.println("Press 7 to Change Your User Name And Password");
		System.out.println("Press 8 to Logout");
		String input = scan.nextLine();

		switch (input) {

		case "1":
			return new DepositScreen(curr);
		case "2":
			return new WithdrawalScreen(curr);
		case "3":
			return new ViewBalanceScreen(curr);
		case "4":
			dao.printTrans(curr.getId());
			break;
		case "5":
			return new QuickPayScreen(curr);
		case "6":
			 return new TransferScreen(curr);
		case "7":
			return new ChangeUserAndPassScreen(curr);
		case "8":
			return new MainMenu();
		default:
			System.out.println("invalid option\n");
			break;
		}
		return new UserAccountScreen(curr);
	}
}
