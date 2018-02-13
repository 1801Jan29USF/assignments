package com.revature.screens;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.bankapp.Bank;

import com.revature.bankapp.BankUser;
import com.revature.dao.BankUserDAO;

/**
 * The initial screen or main menu of the application. Handles log in and
 * registering of new accounts.
 * 
 * @author Rick
 *
 */
public class InitialScreen implements Screen {
	Bank b = Bank.getSingleton();
	Scanner scan = new Scanner(System.in);
	BankUserDAO bd = new BankUserDAO();

	/*
	 * Implementing prompt() of Screen interface.
	 * 
	 * @see com.revature.bankapp.Screen#prompt()
	 */
	@Override
	public Screen prompt() {

		BankUser user = new BankUser();
		System.out.println("Welcome to SlickRick's Financial Institution! \nPress 1 to sign in, "
				+ "2 to sign up, or 3 to delete your account: ");
		String input = scan.nextLine();
		switch (input) {
		case "1":
			System.out.println("Please enter your username: ");
			input = scan.nextLine();
			int j = 0;
			while (!b.checkUsername(input)) {
				if (j == 3) {
					System.out.println("No account has been found under that username. Please sign up by pressing 2.");
					timeOut();
					return new InitialScreen();
				}
				System.out.println("There seems to be no user account connected to that username.Try again!");
				System.out.println("Please enter your username: ");
				input = scan.nextLine();
				j++;
			}
			System.out.println("Please enter your password: ");
			input = scan.nextLine();
			int i = 0;
			while (!b.checkPassword(input)) {
				if (i == 3) {
					System.out.println("You are locked out. Returning to main menu.");
					timeOut();
					return new InitialScreen();
				}
				System.out.println("Incorrect password!");
				System.out.println("Please enter your password: ");
				input = scan.nextLine();
				i++;
			}
			System.out.println("Logged in!");
			timeOut();
			return new AtmScreen();
		case "2":
			System.out.println("To register please enter your username : ");
			input = scan.nextLine();
			while (b.checkUsername(input)) {
				System.out.println("That username already exist. Please enter a new one.");
				System.out.println("Please enter your username: ");
				input = scan.nextLine();
				b.checkUsername(input);
			}
			user.setUsername(input);
			System.out.println("Please choose a password : ");
			input = scan.nextLine();
			user.setPassword(input);
			System.out.println("Please deposit a starting balance : ");
			try {
			user.setBalance(scan.nextDouble());
			} catch (InputMismatchException e) {
				System.out.println("Oops, it seems you do not know how to input numbers or just wanna crash my app!");
				System.out.println("Try to input a valid balance.");
				timeOut();
				return new InitialScreen();
			}
			b.getList().add(user);
			bd.save(user);
			System.out.println("Your account has beeen created under:\n" + user.toString());
			System.out.println("Now taking you to the main menu.");
			timeOut();
			return new InitialScreen();
		case "3":
			System.out.println("To delete your account, enter your username: ");
			input = scan.nextLine();
			int k = 0;
			while (!b.checkUsername(input)) {
				if (k == 3) {
					System.out.println("No account has been found under that username. Returning to main menu.");
					timeOut();
					return new InitialScreen();
				}
				System.out.println("There seems to be no user account connected to that username.Try again!");
				System.out.println("Please enter your username: ");
				input = scan.nextLine();
				k++;
			}
			System.out.println("Please enter your password: ");
			input = scan.nextLine();
			int l = 0;
			while (!b.checkPassword(input)) {
				if (l == 3) {
					System.out.println("You are locked out. Returning to the main menu.");
					timeOut();
					return new InitialScreen();
				}
				System.out.println("Incorrect password!");
				System.out.println("Please enter your password: ");
				input = scan.nextLine();
				l++;
			}
			bd.delete(b.getUser());
			System.out.println("Your account deletion has been a success!");
			System.out.println("Returning to the main menu.");
			timeOut();
			return new InitialScreen();
		default:
			break;
		}
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
