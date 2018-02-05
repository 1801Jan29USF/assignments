package com.revature.screens;

import com.revature.beans.BankUser;
import com.revature.util.BankUserSerializer;
import com.revature.util.CommandLineScannerSingleton;

/**
 * Logs the user into an existing account.  Returns them to the Start Screen in the
 * event of an invalid input.
 * @author poblo
 *
 */
public class LoginScreen implements Screen {

	public LoginScreen() {
		super();
	}

	public Screen prompt() {
		System.out.println("Please input your Username:");
		String input = CommandLineScannerSingleton.getSc().nextLine();
		BankUser currentUser;
		// Checks whether or not an account of the given name already exists
		
		try {
			currentUser = BankUserSerializer.attemptReadBankUser("src/UserData/" + input + ".txt");
		} catch (Exception e) {
			// Kicks user back to the Start Screen if no such account exists
			System.out.println("No user of that name exists.");
			System.out.println();
			return new StartScreen();
		}
		System.out.println("Please input your password:");
		input = CommandLineScannerSingleton.getSc().nextLine();
		
		
		// Checks whether or not the given password is accurate for the existing account
		if (!input.equals(currentUser.getPassword())) {
			System.out.println("I'm sorry, the password you entered does not match that Username");
			System.out.println();
			return new StartScreen();
		}		
		// Forwards the user to the Main Menu in the event of a successful login
		System.out.println("You have successfully logged in! Welcome " + currentUser.getUsername());
		System.out.println();
		return new MainMenu(currentUser);
	}
	
}
