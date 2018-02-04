package com.bank.screens;

import java.util.*;

import com.bank.beans.AuthUser;
import com.bank.util.UserSerializer;
import com.bank.screens.LoginScreen;

/**
 * Main menu screen in the banking application. After a current user is set,
 * prompts the user for a given input, or allows them to log out of the system.
 *
 */
public class MainMenu implements Screen {

	@Override
	public Screen prompt() {
		UserSerializer us = UserSerializer.getUserSerializer();
		Scanner scan = new Scanner(System.in);
		AuthUser current = us.getCurrentuser();
		us.serializeUser(us.getUsers());

		System.out.println("Welcome to the Main Menu " + us.getCurrentuser().getUsername() + ", select an option.");
		System.out.println("Type 1 to view your balance and info.");
		System.out.println("Type 2 to make a deposit.");
		System.out.println("Type 3 to make a withdrawal.");
		System.out.println("Type 9 to log out.");

		String input = scan.nextLine();

		switch (input) {
		//returns balance information of the current user
		case "1":
			List<AuthUser> users = us.getUsers();
			System.out.println("Your balance is: " + us.getCurrentuser().getBalance());
			return new MainMenu().prompt();
		//sends user to deposit screen
		case "2":
			return new DepositScreen().prompt();
		//sends user to withdrawal screen
		case "3":
			return new WithdrawScreen().prompt();
		//logout function to return to login screen
		case "9":
			us.serializeUser(us.getUsers());
			return new LoginScreen().prompt();

		case "close":
			System.exit(0);
		//if none of the above cases, invalid selection warning.
		default:
			System.out.println("Invalid selection.");
			return new MainMenu().prompt();
		}
	}

}
