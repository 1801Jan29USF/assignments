package com.revature.screens;

import org.apache.log4j.Logger;

import com.revature.beans.Bank;
import com.revature.file.io.Serializer;
import com.revature.singleton.ScannerSingleton;

public class OpenScreen implements Screen {

	private final ScannerSingleton scan = ScannerSingleton.getScannerSingleton();
	private Serializer<Bank> bankSerializer = new Serializer<Bank>();
	Bank bank = bankSerializer.deSerialize(Bank.class.getSimpleName() + ".txt");
	private static Logger log = Logger.getRootLogger();

	public OpenScreen() {
		super();
		log.info("Creating OpenScreen");
		log.info("Prompting OpenScreen");
		prompt();
	}
	
	@Override
	public Screen prompt() {
		log.info("Deserializing Bank");
		bank = bankSerializer.deSerialize(Bank.class.getSimpleName() + ".txt");
		log.info("Displaying OpenScreen menu");
		System.out.println("1 to login");
		System.out.println("2 to register");
		System.out.println("3 to quit");
		log.info("Getting user input");
		switch (scan.nextLine()) {
		case "1":
			log.debug("User selected to login");
			log.info("Returning LoginScreen");
			return new LoginScreen(bank);

		case "2":
			log.debug("User selected to register");
			log.info("Returning RegistrationScreen");
			return new RegistrationScreen(bank);

		case "3":
			log.debug("User selected to quit");
			System.out.println("Good bye!");
			log.info("Exiting application");
			System.exit(0);
			break;

		default:
			log.debug("User entered invalid input");
			System.out.println("Invalid input, please try again");
			log.info("Returning OpenScreen");
			return new OpenScreen();
		}
		log.warn("Switch did not handle user input correctly");
		return null;
	}

}
