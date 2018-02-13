package com.revature.screens;

import java.sql.SQLException;

import com.revature.util.CommandLineScannerSingleton;
import com.revature.util.JDBCSingleton;

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
		String userName = CommandLineScannerSingleton.getSc().nextLine();
		// Checks whether or not an account of the given name already exists
		boolean userExists = false;
		try {
			userExists = JDBCSingleton.getJD().userExists(userName);
		} catch (Exception e) {
			// Catches network errors
			System.out.println("I'm sorry, something has gone wrong with the network");
			System.out.println();
			return new StartScreen();
		}
		if (!userExists)  {
			System.out.println("I'm sorry, no user of that name exists.");
			System.out.println();
			return new StartScreen();
		}
		System.out.println("Please input your password:");
		String passWord = CommandLineScannerSingleton.getSc().nextLine();
		
		
		// Checks whether or not the given password is accurate for the existing account
		boolean correctPassword = false;
		try {
			correctPassword = JDBCSingleton.getJD().correctPassword(userName, passWord);
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("I'm sorry, something went wrong with the network. Please try again later.");
			System.out.println();
			return new StartScreen();
		}
		if (!correctPassword) {
			System.out.println("I'm sorry, the password you entered does not match that Username");
			System.out.println();
			return new StartScreen();
		}		
		// Forwards the user to the Main Menu in the event of a successful login
		System.out.println("You have successfully logged in! Welcome " + userName + "!");
		System.out.println();
		return new MainMenu(userName);
	}
	
}
