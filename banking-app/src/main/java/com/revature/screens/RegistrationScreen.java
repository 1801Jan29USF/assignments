package com.revature.screens;

import org.apache.log4j.Logger;

import com.revature.beans.Bank;
import com.revature.beans.User;
import com.revature.file.io.Serializer;
import com.revature.singleton.ScannerSingleton;

public class RegistrationScreen implements Screen {
	
	private final ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	private Bank bank;
	private static Logger log = Logger.getRootLogger();
	
	public RegistrationScreen() {
		super();
		log.info("Creating RegistrationScreen");
		log.info("Prompting RegistrationScreen");
		prompt();
	}

	public RegistrationScreen(Bank bank) {
		super();
		log.info("Creating RegistrationScreen");
		log.info("Setting this.bank");
		this.bank = bank;
		log.info("Prompting RegistrationScreen");
		prompt();
	}

	@Override
	public Screen prompt() {
		log.info("Creating bankSerializer");
		Serializer<Bank> bankSerializer = new Serializer<>();
		log.info("Deserializing bank");
		bank = bankSerializer.deSerialize("Bank.txt");
		log.info("Displaying RegisrtationScreen menu");
		System.out.println("Username:");
		String userName = scan.nextLine();
		log.debug("User submitted a user name");
		System.out.println("Password:");
		String password = scan.nextLine();
		log.debug("User submitted a password");
		log.info("Checking if user name was empty");
		if (userName.isEmpty() || password.isEmpty()) {
			log.info("User name/password invalid: empty string");
			System.out.println("User name/password cannot be empty, returning to opening screen");
			return new OpenScreen();
		}
		log.info("Checking is user name already exists");
		if (!bank.getUsers().containsKey(userName)) {
			log.info("User name does not yet exist");
			log.info("Creating new user with user submitted user name and password");
			User newUser = new User(userName, password);
			log.info("Adding user to bank");
			bank.getUsers().put(userName, newUser);
			log.info("Serializing bank");
			bankSerializer.serialize(bank);
			log.info("Returning MainMenu");
			return new MainMenu(newUser);
		} else {
			log.info("User name already exists");
			System.out.println("User already exists");
			System.out.println("Returing to opening menu");
			log.info("Returning OpenScreen");
			return new OpenScreen();
		}
	}

}
