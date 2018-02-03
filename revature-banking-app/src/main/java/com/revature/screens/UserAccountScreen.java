package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Bank;

public class UserAccountScreen implements Screen {

	public UserAccountScreen(Bank bank, Account curr) {
		super();
		this.bank = bank;
		this.curr = curr;
	}

	private Bank bank;
	private Account curr;
	private Scanner scan = new Scanner(System.in);

	private void printTransHis() {
		System.out.println("Your Transactions");
		for (String t : curr.transactions) {
			System.out.println(t);
		}
	}

	@Override
	public Screen prompt() {
		System.out.println("How can we help you?");
		System.out.println("Press 1 for Deposit: ");
		System.out.println("Press 2 for Withdrawal: ");
		System.out.println("Press 3 to view Account Balance: ");
		System.out.println("Press 4 to view Transaction History: ");
		System.out.println("Press 5 to Logout");

		String input = scan.nextLine();

		switch (input) {

		case "1":
			System.out.println("Please Enter Amount for Deposit: ");
			bank.deposit(curr, Integer.parseInt(scan.nextLine()));
			break;
		case "2":
			System.out.println("Please Enter Amount for Withdrawal: ");
			bank.withdraw(curr, Integer.parseInt(scan.nextLine()));
			break;
		case "3":
			bank.viewBalance(curr);
			break;
		case "4":
			printTransHis();
			break;
		case "5":
			return new MainMenu(bank);
		default:
			System.out.println("invalid option");
			break;
		}
		return new UserAccountScreen(bank, curr);
	}
}
