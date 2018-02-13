package com.revature.screens;

import java.sql.SQLException;

import com.revature.util.CommandLineScannerSingleton;
import com.revature.util.JDBCSingleton;


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
		// Creates a BankUser with the given name and password, having a balance of $0
		// Checks if a BankUser of the given username is already serialized
		boolean userExists;
		try {
			userExists = JDBCSingleton.getJD().userExists(userName);
		} catch (SQLException e1) {
			System.out.println("I'm sorry, something went wrong with the network. Please try again later.");
			System.out.println();
			return new StartScreen();
		}
		if (userExists) {
			// Returns the user to the Start Screen if the name is already in use.
			System.out.println("I'm sorry, a user of that name already exists.");
			System.out.println();
		 	return new StartScreen();
		}
		System.out.println("Please enter your password");
		String passWord = CommandLineScannerSingleton.getSc().nextLine();
		// Serializes the new user into a file with the name username + ".txt"
		try {
			JDBCSingleton.getJD().makeUser(userName, passWord);
		} catch (SQLException e) {
			System.out.println("I'm sorry, something has gone wrong with your registration.");
			System.out.println();
			return new StartScreen();	
		}
		System.out.println("You have successfully been registered!");
		return new StartScreen();
	}

}
