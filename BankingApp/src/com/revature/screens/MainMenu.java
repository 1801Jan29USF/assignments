package com.revature.screens;

import com.revature.beans.BankUser;
import com.revature.util.CommandLineScannerSingleton;

/**
 * Main Menu screen which acts as a hub for the user's activities within their
 * account. Calls BankUser's class methods to handle requests for the user's
 * current balance and transaction history. Forwards user to WithdrawScreen in the
 * event of a withdrawal and DepositScreen for deposits. Shepherds the user back to the
 * StartScreen if they request to log out.
 * 
 * @author poblo
 *
 */
public class MainMenu implements Screen {
	BankUser user;

	public MainMenu(BankUser currentUser) {
		this.user = currentUser;
	}

	public Screen prompt() {
		System.out.println("You are currently logged in as " + this.user.getUsername());
		System.out.println("Press 1 to see your balance");
		System.out.println("Press 2 to make a withdrawal");
		System.out.println("Press 3 to make a deposit");
		System.out.println("Press 4 to see your transaction history");
		System.out.println("Press 5 to log out");
		String input = CommandLineScannerSingleton.getSc().nextLine();
		switch (input) {
		case "1":
			System.out.println("Your balance is $" + this.user.getBalance());
			System.out.println();
			System.out.println("Press enter to return to Main Menu");
			input = CommandLineScannerSingleton.getSc().nextLine();
			// input = sc.nextLine();
			return new MainMenu(this.user);
		case "2":
			return new WithdrawScreen(this.user);
		case "3":
			return new DepositScreen(this.user);
		case "4":
			System.out.println();
			this.user.printTransactionHistory();
			System.out.println();
			System.out.println("Press enter to return to Main Menu");
			input = CommandLineScannerSingleton.getSc().nextLine();
			// input = sc.nextLine();
			return new MainMenu(this.user);
		case "5":
			return new StartScreen();
		default:
			System.out.println("Invalid input.");
			System.out.println();
			return new MainMenu(this.user);
		}

	}

}
