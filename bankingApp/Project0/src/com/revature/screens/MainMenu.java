package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;

/**
 * The main menu contains a basic console menu.
 * Allows access to the DepositScreen, WithdrawalScreen, and the ability to return to the LoginScreen 
 * 
 * @author Ben Z
 *
 * To be honest I'm not sure what you want us to put here. Most of the code is pretty straight forward I think. 
 * There are a couple sysout("") scattered around. Those are simply for making the console more readable.
 */
public class MainMenu implements Screen {
	private User currentUser;
	
	public MainMenu(User currentUser) {
		super();
		this.currentUser = currentUser;
	}

	@Override
	public Screen prompt() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the Main Menu, " + currentUser.getUsername() + ".");
		System.out.println("What would you like to do?");
		System.out.println("1 - Make a deposit.");
		System.out.println("2 - Make a withdrawal.");
		System.out.println("3 - View Balance.");
		System.out.println("4 - Log Out.");
		String input = scan.nextLine();
		System.out.println("");
		 
		switch (input) {
		case "1":
			return new DepositScreen(currentUser);
		case "2":
			return new WithdrawalScreen(currentUser);
		case "3":
			System.out.println("Current balance: $" + currentUser.getBalance() + "\n");
			return new MainMenu(currentUser);
		case "4":
			System.out.println("Logging out.\n");
			return new LoginScreen();
		default:
			break;
		}
		
		return new MainMenu(currentUser);
	}

}
