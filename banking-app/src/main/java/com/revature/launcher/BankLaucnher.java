package com.revature.launcher;

import org.apache.log4j.Logger;

import com.revature.screens.OpenScreen;
import com.revature.screens.Screen;

public class BankLaucnher {
	
	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		log.info("Launching bank application");
		log.info("Creating OpenScreen");
		Screen screen = new OpenScreen();
		log.info("Begining main program loop");
		while (true) {
			log.info("Promting OpenScreen");
			screen.prompt();
		}
	}

}
