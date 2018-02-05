package com.revature.screens;

import org.apache.log4j.Logger;

import com.revature.beans.Bank;
import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.file.io.Serializer;
import com.revature.singleton.ScannerSingleton;

public class MainMenu implements Screen {

	private final ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	private static Logger log = Logger.getRootLogger();
	private User user;

	public MainMenu() {
		super();
		log.info("Creating MainMenu");
		log.info("Prompting MainMenu");
		prompt();
	}
	
	public MainMenu(User user) {
		super();
		log.info("Creating MainMenu");
		log.info("Setting user");
		this.user = user;
		log.info("Prompting MainMenu");
		prompt();
	}
	
	@Override
	public Screen prompt() {
		System.out.println("Current balance: " + user.getBalance());
		log.info("Displaying MainMenu");
		System.out.println("1 to make a transaction");
		System.out.println("2 to make a logout");
		System.out.println("3 to to view transaction history");
		log.info("Getting user input");
		switch (scan.nextLine()) {
		case "1":
			log.debug("User selected to make a transaction");
			log.info("Returning TransactionScreen");
			return new TransactionScreen(user);

		case "2":
			log.debug("User selected to logout");
			log.info("Creating Bank Sreializer");
			Serializer<Bank> serializer = new Serializer<Bank>();
			log.info("Creating new bank from Bank serializer");
			Bank bank = serializer.deSerialize("Bank.txt");
			log.info("Updating user to bank");
			bank.getUsers().replace(user.getUserName(), user);
			log.info("Serializing bank");
			serializer.serialize(bank);
			log.info("Returning OpenScreen");
			return new OpenScreen();
			
		case "3":
			log.debug("User selected to view transaction history");
			log.info("Iterating through user's transactions");
			for (Transaction transaction : user.getTransactions()) {
				log.info("Displaying a transaction");
				System.out.println(transaction);
			}

		default:
			log.debug("User entered invalid input");
			System.out.println("Invalid input, please try again");
			log.info("Returning MainMenu");
			return new MainMenu(user);
		}
	}

}
