package com.revature.screens;

import java.sql.Timestamp;
import java.util.Scanner;

import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

public class AccountScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private BankDAOJDBC bd = new BankDAOJDBC();
	private User u = User.getUser();
	private Transaction t = Transaction.getTransaction();

	@Override
	public Screen prompt() {
		System.out.println("Welcome to the Bank of Monsters Account Page!");
		System.out.println("Please select an option: ");
		System.out.println("Enter 1 to deposit to your account.");
		System.out.println("Enter 2 to withdraw from your account.");
		System.out.println("Enter 3 to view your current balance.");
		System.out.println("Enter 4 to view your transactions.");
		System.out.println("Enter 5 to go back to the main menu.");
		
		String input = scan.nextLine();
		
		switch (input) {
		case "1":
			System.out.println("Please insert the amount you would like to deposit: ");
			double balance = 0;
			try {
				balance = Double.parseDouble(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input.");
			}
			
			t.setDeposited(balance);
			t.setWithdrawn(0);
			t.setUserId(u.getId());
			t.setDate(new Timestamp(System.currentTimeMillis()));
			
			u.setBalance(u.getBalance() + balance);
			
			bd.deposit(u, balance);
			bd.addTransaction(u, t);
			
			System.out.println("You have input " + balance + " into your bank account.");
			System.out.println("Your current total is: " + u.getBalance() + "\n");
			
			return new AccountScreen();
			
		case "2":
			System.out.println("Please insert the amount you would like to withdraw: ");
			double balance1 = 0;
			try {
				balance1 = Double.parseDouble(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input.");
			}
			
			t.setDeposited(0);
			t.setWithdrawn(balance1);
			t.setUserId(u.getId());
			t.setDate(new Timestamp(System.currentTimeMillis()));
			
			u.setBalance(u.getBalance() - balance1);
			bd.withdraw(u, balance1);
			bd.addTransaction(u, t);
			
			System.out.println("You have withdrawn " + balance1 + " from your bank account.");
			System.out.println("Your current total is: " + u.getBalance() + "\n");
			
			return new AccountScreen();
			
		case "3":
			System.out.println("Your current balance is: " + u.getBalance());
			
			return new AccountScreen();
			
		case "4":
			System.out.println("Here are all of the transactions you have made: ");
			System.out.println(bd.getTransactions(u.getId()));
			
			return new AccountScreen();
			
		case "5":
			return new MainMenu();
			
		default:
			System.out.println("Invalid option.");
			
			break;
		}
		return new MainMenu();
	}
}