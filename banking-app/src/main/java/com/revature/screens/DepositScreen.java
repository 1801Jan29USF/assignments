package com.revature.screens;

import java.util.Calendar;

import org.apache.log4j.Logger;

import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.exceptions.NotANumberException;
import com.revature.singleton.ScannerSingleton;
import com.revature.strings.checkers.IsNumericChecker;

public class DepositScreen implements Screen {

	private final ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	private static Logger log = Logger.getRootLogger();
	private User user;

	public DepositScreen() {
		super();
		log.info("Creating DepositScreen");
		log.info("Prompting DepositScreen");
		prompt();
	}

	public DepositScreen(User user) {
		super();
		log.info("Creating DepositScreen");
		log.info("Setting ths.user");
		this.user = user;
		log.info("Prompting DepositScreen");
		prompt();
	}

	@Override
	public Screen prompt() {
		log.info("Displaying DepositScreen");
		System.out.println("Please enter the amount you would like to Deposit:");
		log.debug("Attempting to get user input");
		try {
			makeDeposit(scan);
		} catch (NotANumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MainMenu(user);
	}

	private void makeDeposit(ScannerSingleton scan) throws NotANumberException {
		log.info("Getting to get user input");
		String input = scan.nextLine();
		log.info("Checking if user input is a number or is empty");
		if (!IsNumericChecker.isNumeric(input) || input.isEmpty()) {
			log.info("User input is invalid: NaN");
			System.out.println("Amount entered was not a number, no trasaction was made");
			log.info("Returing DepositScreen");
			// return new MainMenu();
		} else {
			log.debug("User input is number, attempting deposit");
			deposit(Float.parseFloat(input));
		}
	}

	private User deposit(Float amount) {
		log.info("Checking if user input is valid");
		if (amount <= 0) {
			log.debug("User input is invalid: amount entered was negative or zero");
			System.out.println("Amount ender was negative value or zero, no transaction was made");
			log.info("Returing MainMenu");
			return user;
		} else {
			log.debug("User input is valid, depositing funds");
			user.setBalance(user.getBalance() + amount);
			log.info("Recording transaction");
			user.getTransactions().add(new Transaction(amount, Calendar.getInstance().getTime()));
			System.out.println("Deposit sucessful, press ENTER to return to the main menu");
			log.info("Getting user input");
			scan.nextLine();
			log.debug("User input = ENTER");
			log.info("Returning MainMenu");
			return user;
		}
	}

}
