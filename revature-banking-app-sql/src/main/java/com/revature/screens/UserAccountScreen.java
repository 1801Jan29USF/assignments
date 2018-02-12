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
		System.out.println("Press 1 to Add A New Account: ");
		System.out.println("Press 2 for Delete An Existing Account: ");
		System.out.println("Press 3 for Deposit: ");
		System.out.println("Press 4 for Withdrawal: ");
		System.out.println("Press 5 to View Account Balance: ");
		System.out.println("Press 6 to View Transaction History: ");
		System.out.println("Press 7 to QuickPay");
		System.out.println("Press 8 to Transfer Money");
		System.out.println("Press 9 to Change Your User Name And Password");
		System.out.println("Press 10 to Logout");
		System.out.println("Press 11 to Delete Your User Profile");
		String input = scan.nextLine();

		switch (input) {
		
		case "1":
			return new CreateAccountScreen(curr);
		case "2":
			return new DeleteAccountScreen(curr);
		case "3":
			return new DepositScreen(curr);
		case "4":
			return new WithdrawalScreen(curr);
		case "5":
			return new ViewBalanceScreen(curr);
		case "6":
			dao.printTrans(curr.getId());
			break;
		case "7":
			return new QuickPayScreen(curr);
		case "8":
			 return new TransferScreen(curr);
		case "9":
			return new ChangeUserAndPassScreen(curr);
		case "10":
			return new MainMenu();
		case "11":
			return new DeleteUserProfileScreen(curr);
		default:
			System.out.println("invalid option\n");
			break;
		}
		return new UserAccountScreen(curr);
	}
}
