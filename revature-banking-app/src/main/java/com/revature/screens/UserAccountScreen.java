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

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("How can we help you?\n");
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
			int depositAmt = 0;
			try {
				depositAmt = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input for deposit\n");
				break;
			}
			if (depositAmt < 0) {
				System.out.println("Deposit amount must be greater or equal to 0\n");
				break;
			}
			System.out.println("Press s for Savings");
			System.out.println("Press c for Checking");
			String type = scan.nextLine();
			if (!((type.hashCode() == "s".hashCode()) || (type.hashCode() == "c".hashCode()))) {
				System.out.println("Invalid account option\n");
				break;
			}
			bank.deposit(curr, depositAmt, type);
			break;
		case "2":
			System.out.println("Please Enter Amount for Withdrawal: ");
			int withdrawAmt = 0;
			try {
				withdrawAmt = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input for withdrawal\n");
				break;
			}
			if (withdrawAmt < 0) {
				System.out.println("Withdrawal amount must be greater or equal to 0\n");
				break;
			}
			bank.withdraw(curr, withdrawAmt);
			break;
		case "3":
			System.out.println("Press s for Savings");
			System.out.println("Press c for Checking");
			String type2 = scan.nextLine();
			if (!((type2.hashCode() == "s".hashCode()) || (type2.hashCode() == "c".hashCode()))) {
				System.out.println("Invalid account option\n");
				break;
			}
			bank.balance(curr, input);
			break;
		case "4":
			bank.printTrans(curr);
			break;
		case "5":
			return new QuickPayScreen(bank, curr);
		case "6":
			System.out.println("Enter amount for transfer");
			int transferAmt = 0;
			try {
				transferAmt = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input for transfer\n");
				break;
			}
			if (transferAmt < 0) {
				System.out.println("Transfer amount must be greater or equal to 0\n");
				break;
			}
			bank.transfer(curr, transferAmt);
			break;
		case "7":
			bank.users = bank.us.DeserializeUsers("Users.txt");
			return new MainMenu(bank);
		default:
			System.out.println("invalid option\n");
			break;
		}
		return new UserAccountScreen(bank, curr);
	}
}
