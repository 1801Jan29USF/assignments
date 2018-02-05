package com.revature.screens;

import com.revature.util.CommandLineScannerSingleton;

/**
 * THe first screen the user encounters. Prompts the user to either register an
 * account or sign in to an existing account
 * 
 * @author poblo
 *
 */
public class StartScreen implements Screen {

	public StartScreen() {
		super();
	}

	// Prompts the user to either register an account or sign in to an existing one
	public Screen prompt() {
		System.out.println("If you are a registered user of this bank, please press 1");
		System.out.println("If you would like to register an account, press 2");
		String input = CommandLineScannerSingleton.getSc().nextLine();
		switch (input) {
		case "1":
			return new LoginScreen();
		case "2":
			return new SignupScreen();
		default:
			System.out.println("Invalid input");
			break;
		}
		return new StartScreen();
	}

}
