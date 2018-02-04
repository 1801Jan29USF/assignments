package com.revature.screens;

import java.util.Scanner;

import com.revature.bankapp.Bank;
import com.revature.bankapp.BankSerializer;
import com.revature.bankapp.BankUser;

/**
 * The initial screen or main menu of the application.
 * Handles log in and registering of new accounts.
 * @author Rick
 *
 */
public class InitialScreen implements Screen {
	Bank b = Bank.getSingleton();
	BankSerializer bank = new BankSerializer();
	Scanner scan = new Scanner(System.in);
	
	/*
	 * Implementing prompt() of Screen interface.
	 * @see com.revature.bankapp.Screen#prompt()
	 */
	@Override
	public Screen prompt() {
		
		BankUser user = new BankUser();
		System.out.println("Welcome to Slickrick Financial Institution! \nPress 1 to sign in or 2 to sign up: ");
		String input = scan.nextLine();
		switch (input) {
		case "1":
			System.out.println("Please enter your username: ");
			input = scan.nextLine();
			int j=0;
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
					System.out.println("You are locked out. Returning to log in screen.");
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
			user.setUsername(input);
			System.out.println("Please choose a password : ");
			input = scan.nextLine();
			user.setPassword(input);
			System.out.println("Please deposit a starting balance : ");
			user.setBalance(scan.nextDouble());
			b.getList().add(user);
			System.out.println("Your account has beeen created under:\n" + user.toString());
			System.out.println("Now taking you to the log in screen.");
			bank.serializeBankUsers(b.getList());
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
