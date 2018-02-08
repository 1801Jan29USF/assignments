package com.revature.screens;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.singleton.ScannerSingleton;

public class TransactionScreen implements Screen {

	private final ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	private static Logger log = Logger.getRootLogger();
	private User user;

	public TransactionScreen() {
		super();
		log.info("Creating TransactionScreen");
		log.info("Prompting TransactionScreen");
		prompt();
	}
	
	public TransactionScreen(User user) {
		super();
		log.info("Creating TransactionScreen");
		log.info("Setting this.user");
		this.user = user;
		log.info("Prompting TransactionScreen");
		prompt();
	}

	@Override
	public Screen prompt() {
		log.info("Displaying TransactionScreen");
		System.out.println("1 to make a withdrawal");
		System.out.println("2 to make a deposit");
		System.out.println("3 to return to main menu");
		log.info("Getting user input");
		switch (scan.nextLine()) {
		case "1":
			log.debug("User chose to make a withdrawal");
			log.info("Returning WithdrawalScreen");
			return new WithdrawalScreen(user);

		case "2":
			log.debug("User chose to make a deposit");
			log.info("Returning DepositScreen");
			return new DepositScreen(user);

		case "3":
			log.debug("User chose to return to the main menu");
			log.info("Returning MainMenu");
			return new MainMenu(user);

		default:
			log.debug("User entered invalid input");
			System.out.println("Invalid input, please try again");
			log.info("Returning TransactionScreen");
			return new TransactionScreen(user);
		}
	}

}
