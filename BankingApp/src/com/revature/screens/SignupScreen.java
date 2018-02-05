package com.revature.screens;

import java.io.File;

import com.revature.beans.BankUser;
import com.revature.util.BankUserSerializer;
import com.revature.util.CommandLineScannerSingleton;

/**
 * Screen which handles user input for the sign-up process. Takes a username
 * and password, creates a BankUser object with the given fields, serializes
 * that object, and returns the user to the start menu. Boots the user to the
 * start menu if a BankUser with the same username alredy exists.
 * @author poblo
 *
 */
public class SignupScreen implements Screen {
	
	
	public SignupScreen() {
		super();
	}


	@Override
	public Screen prompt() {
		// Reads a username and password from the user
		System.out.println("Please enter your username");
		String userName = CommandLineScannerSingleton.getSc().nextLine();
		System.out.println("Please enter your password");
		String passWord = CommandLineScannerSingleton.getSc().nextLine();
		// Creates a BankUser with the given name and password, having a balance of $0
		BankUser newUser = new BankUser(userName, passWord);
		// Checks if a BankUser of the given username is already serialized
		File nf = new File(newUser.getFile());
		if ( nf.exists()) {
			// Returns the user to the Start Screen if the name is already in use.
			System.out.println("I'm sorry, a user of that name already exists");
			System.out.println();
			return new StartScreen();
		}
		// Serializes the new user into a file with the name username + ".txt"
		try {
			BankUserSerializer.attemptWriteBankUser(newUser, newUser.getFile());
		} catch (Exception e) {
			System.out.println("I'm sorry, something has gone wrong with your registration.");
			System.out.println();
			return new StartScreen();	
		}
		System.out.println("You have successfully been registered!");
		return new StartScreen();
	}

}
