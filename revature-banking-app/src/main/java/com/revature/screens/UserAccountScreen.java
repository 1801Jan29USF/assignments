package com.revature.screens;

import java.util.Scanner;
import com.revature.beans.Bank;
import com.revature.beans.User;

public class UserAccountScreen implements Screen {

	public UserAccountScreen(Bank bank, User curr) {
		super();
		this.curr = curr;
		prompt(bank);
	}

	private User curr;
	private Scanner scan = new Scanner(System.in);

	private void printTrans() {
		System.out.println("Your Transactions");
		for (String t : curr.transactions) {
			System.out.println(t);
		}
	}

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("How can we help you?");
		System.out.println("Press 1 for Deposit: ");
		System.out.println("Press 2 for Withdrawal: ");
		System.out.println("Press 3 to View Account Balance: ");
		System.out.println("Press 4 to View Transaction History: ");
		System.out.println("Press 5 to QuickPay");
		System.out.println("Press 6 to Transfer Money from Checking to Savings");
		System.out.println("Press 7 to Logout");

		String input = scan.nextLine();

		switch (input) {

		case "1":
			System.out.println("Please Enter Amount for Deposit: ");
			int depositAmt = Integer.parseInt(scan.nextLine());
			System.out.println("Press s for Savings");
			System.out.println("Press c for Checking");
			String type = scan.nextLine();
			bank.deposit(curr, depositAmt, type);
			break;
		case "2":
			System.out.println("Please Enter Amount for Withdrawal: ");
			int withdrawAmt = Integer.parseInt(scan.nextLine());
			bank.withdraw(curr, withdrawAmt);
			break;
		case "3":
			System.out.println("Press s for Savings");
			System.out.println("Press c for Checking");
			input = scan.nextLine();
			bank.balance(curr, input);
		case "4":
			System.out.println("Press s for Savings");
			System.out.println("Press c for Checking");
			input = scan.nextLine();
			bank.balance(curr, input);
			printTrans();
			break;
		case "5":
			return new QuickPayScreen(bank, curr);
		case "6":
			System.out.println("Enter amount for transfer");
			int transferAmt = Integer.parseInt(scan.nextLine());
			bank.transfer(curr, transferAmt);
			break;
		case "7":
			return new MainMenu(bank);
		default:
			System.out.println("invalid option");
			break;
		}
		return new UserAccountScreen(bank, curr);
	}
}
