package com.revature.screens;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Transaction;
import com.revature.util.CommandLineScannerSingleton;
import com.revature.util.JDBCSingleton;

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
	String username;

	public MainMenu(String username) {
		this.username = username;
	}

	public Screen prompt() {
		Logger log = Logger.getRootLogger();
		System.out.println("You are currently logged in as " + this.username);
		System.out.println("Press 1 to see your balance");
		System.out.println("Press 2 to make a withdrawal");
		System.out.println("Press 3 to make a deposit");
		System.out.println("Press 4 to see your transaction history");
		System.out.println("Press 5 to log out");
		String input = CommandLineScannerSingleton.getSc().nextLine();
		switch (input) {
		case "1":
			Double balance = -1.00;
			try {
				balance = JDBCSingleton.getJD().getBalance(username);
			} catch(SQLException e) {
				System.out.println("I'm sorry, something has gone wrong with the network.");
				System.out.println("Your balance could not be displayed.");
				System.out.println();
				return new MainMenu(username);
			}
			if(balance < 0.0) {
				System.out.println("I'm sorry, something went wrong.");
				System.out.println("Your balance could not be displayed.");
				System.out.println();
				return new MainMenu(username);
			}
			System.out.println("Your balance is $" + balance);
			System.out.println();
			System.out.println("Press enter to return to Main Menu");
			input = CommandLineScannerSingleton.getSc().nextLine();
			return new MainMenu(this.username);
		case "2":
			return new WithdrawScreen(this.username);
		case "3":
			return new DepositScreen(this.username);
		case "4":
			System.out.println();
			List<Transaction> tl = new ArrayList<Transaction>();
			try {
				tl = JDBCSingleton.getJD().getTransactionHistory(username);
			} catch (SQLException e) {
				System.out.println("I'm sorry, something went wrong with the network.");
				System.out.println("Your transaction history could not be displayed.");
				System.out.println();
				return new MainMenu(username);
			}
			if (tl.size() == 0) {
				System.out.println("You have not yet made any transactions");
				System.out.println();
				return new MainMenu(username);
			} else {
				for (int i = 0; i < tl.size(); i++) {
					Transaction t = tl.get(i);
					System.out.println(t.toString());
				}
			}
			System.out.println();
			System.out.println("Press enter to return to Main Menu");
			input = CommandLineScannerSingleton.getSc().nextLine();
			return new MainMenu(this.username);
		case "5":
			return new StartScreen();
		default:
			System.out.println("Invalid input.");
			System.out.println();
			return new MainMenu(this.username);
		}

	}

}
