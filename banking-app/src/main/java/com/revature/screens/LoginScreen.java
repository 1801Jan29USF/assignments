package com.revature.screens;

import org.apache.log4j.Logger;

import com.revature.beans.Bank;
import com.revature.beans.User;
import com.revature.singleton.ScannerSingleton;

public class LoginScreen implements Screen {
	
	private final ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	private Bank bank;
	private static Logger log = Logger.getRootLogger();
	
	public LoginScreen() {
		super();
		log.info("Creating LoginScreen");
		log.info("Prompting LoginScreen");
		prompt();
	}

	public LoginScreen(Bank bank) {
		super();
		log.info("Creating LoginScreen");
		log.debug("Setting this.bank");
		this.bank = bank;
		log.info("Prompting LoginScreen");
		prompt();
	}

	@Override
	public Screen prompt() {
		log.info("Displaying LoginScreen menu");
		System.out.println("Username:");
		String userName = scan.nextLine();
		log.debug("User submitted a user name");
		System.out.println("Password:");
		String password = scan.nextLine();
		log.debug("User submitted a password");
		log.info("Checking if login credentials are valid");
		if (bank.getUsers().get(userName).getPassword().equals(password)) {
			log.info("User credentials are correct");
			log.info("Retreiving user");
			User user = bank.getUsers().get(userName);
			log.info("Returning MainMenu");
			return new MainMenu(user);
		} else {
			log.info("User credentials are invalid");
			System.out.println("Incorrect username/password");
			log.info("Returning OpenScreen");
			return new OpenScreen();
		}
	}

}
