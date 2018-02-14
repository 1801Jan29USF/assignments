package com.bank.screens;

import java.util.*;

import org.apache.log4j.Logger;

import com.bank.beans.AuthUser;
import com.bank.dao.BankDAOJDBC;
import com.bank.dao.bankDAO;
//import com.bank.util.UserSerializer;
import com.bank.screens.LoginScreen;

/**
 * Main menu screen in the banking application. After a current user is set,
 * prompts the user for a given input, or allows them to log out of the system.
 *
 */
public class MainMenu implements Screen {

	@Override
	public Screen prompt() {
		// UserSerializer us = UserSerializer.getUserSerializer();
		Scanner scan = new Scanner(System.in);
		Logger log = Logger.getRootLogger();
		bankDAO bdao = BankDAOJDBC.getBdao();

		// System.out.println("current user id is " + bdao.getCurrentUserID());

		System.out.println(("Welcome to the Main Menu, select an option."));
		System.out.println("Type 1 to view your balance and info.");
		System.out.println("Type 2 to make a deposit.");
		System.out.println("Type 3 to make a withdrawal.");
		System.out.println("Type 5 to view your transaction history.");
		System.out.println("Type 9 to log out.");

		String input = scan.nextLine();

		switch (input) {
		// returns balance information of the current user
		case "1":
			log.trace(("Your balance is " + bdao.getUserBal(bdao.getCurrentUserID())));
			return new MainMenu().prompt();

		case "2":
			return new DepositScreen().prompt(); // sends user to deposit screen

		case "3":
			return new WithdrawScreen().prompt(); // sends user to withdrawal screen

		case "5":
			bdao.getUserHistory(bdao.getCurrentUserID());
			return new MainMenu().prompt();
		case "9":
			bdao.setCurrentUserID(0); // logout function to return to login screen
			return new LoginScreen().prompt();

		case "close":
			System.exit(0);
			// if none of the above cases, invalid selection warning.
		default:
			log.warn("Invalid selection.");
			return new MainMenu().prompt();
		}
	}

}
