package com.revature.screens;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.bankapp.Bank;
import com.revature.dao.BankUserDAO;
import com.revature.dao.TransactionDAO;

/**
 * The screen that server as an ATM/personal banking application for the user.
 * 
 * @author Rick
 *
 */
public class AtmScreen implements Screen {

	Bank b = Bank.getSingleton();
	Scanner scan = new Scanner(System.in);
	double withdraw;
	double deposit;
	DecimalFormat df = new DecimalFormat("###.#");
	BankUserDAO bd = new BankUserDAO();
	TransactionDAO ts = new TransactionDAO();

	/*
	 * Implementing prompt() of Screen interface.
	 * 
	 * @see com.revature.bankapp.Screen#prompt()
	 */
	@Override
	public Screen prompt() {
		Date date = new Date();
		b.getUser().setTransactions(ts.getTransactionsList(bd.getid(b.getUser().getUsername())));
		System.out.println("Welcome to your personal banking app:");
		System.out.println("Press 1 for deposit.\nPress 2 for withdrawal.\nPress 3 to view your balance.\n"
				+ "Press 4 for transaction history.");
		String input = scan.nextLine();
		switch (input) {
		case "1":
			System.out.println("How much would you like to deposit:");
			try {
				deposit = scan.nextDouble();
				while (deposit <= 0) {
					System.out
							.println("SlickRick's Financial Insitution does not allow deposits equal or less than 0 .");
					System.out.println("Please enter a valid amount:");
					try {
						deposit = scan.nextDouble();
					} catch (InputMismatchException e) {
						System.out.println(
								"Oops, it seems you do not know how to input numbers or just wanna crash my app!");
						System.out.println("Try again!");
						timeOut();
						return new AtmScreen();
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Oops, it seems you do not know how to input numbers or just wanna crash my app!");
				System.out.println("Try again!");
				timeOut();
				return new AtmScreen();
			}
			b.getUser().setDeposit(deposit);
			b.getUser().getTransactions().add("On " + (String.valueOf(new Timestamp(date.getTime())))
					+ " you made a deposit " + "for the amount of: $" + (String.valueOf(deposit)) + ".\n");
			System.out.println("You deposited the amount of: $" + df.format(deposit));
			ts.savetransaction(new Timestamp(date.getTime()), "deposit", deposit, bd.getid(b.getUser().getUsername()));
			bd.update(b.getUser());
			System.out.println("Your new balance is: $" + df.format(b.getUser().getBalance()));
			break;
		case "2":
			System.out.println("How much would you like to withdraw:");
			try {
				withdraw = scan.nextDouble();
				while ((b.getUser().getBalance()) < withdraw) {
					System.out.println("SlickRick's Financial Insitution does not tolerate overdrafts.");
					System.out
							.println("The amount you are trying to withdraw is greater than your current balance of: $"
									+ df.format(b.getUser().getBalance()));
					System.out.println("Please enter a valid amount:");
					try {
						withdraw = scan.nextDouble();
					} catch (InputMismatchException e) {
						System.out.println(
								"Oops, it seems you do not know how to input numbers or just wanna crash my app!");
						System.out.println("Try again!");
						timeOut();
						return new AtmScreen();
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Oops, it seems you do not know how to input numbers or just wanna crash my app!");
				System.out.println("Try again!");
				timeOut();
				return new AtmScreen();
			}
			b.getUser().setWithdraw(withdraw);
			b.getUser().getTransactions().add("On " + (String.valueOf(new Timestamp(date.getTime())))
					+ " you made a withdrawal " + "for the amount of: $" + (String.valueOf(withdraw)) + ".\n");
			System.out.println("You withdrew the amount of: $" + df.format(withdraw));
			ts.savetransaction(new Timestamp(date.getTime()), "withdrawal", withdraw,
					bd.getid(b.getUser().getUsername()));
			bd.update(b.getUser());
			System.out.println("Your new balance is: $" + df.format(b.getUser().getBalance()));
			break;
		case "3":
			System.out.println("Your current balance is: $" + df.format(b.getUser().getBalance()));
			break;
		case "4":
			System.out.println("Transaction History:\n" + b.getUser().getTransactions().toString().replace(", ", "")
					.replace("[", "").replace("]", "").trim());
		default:
			break;
		}
		return otherTransaction();

	}

	public Screen otherTransaction() {
		System.out.println("Press y for another transaction or anything else to log out. ");
		String input = scan.next();
		if (input.equalsIgnoreCase("y")) {

			return new AtmScreen();

		}
		System.out.println("Logging out");
		timeOut();
		return new InitialScreen();
	}

	/*
	 * Loading bar by pausing main thread.
	 */
	public void timeOut() {
		try {

			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".\n");
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
	}

}
