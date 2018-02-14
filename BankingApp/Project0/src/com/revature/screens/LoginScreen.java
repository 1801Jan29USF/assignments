package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.DAO.UserDAOjdbc;
import com.revature.beans.User;

/**
 * This is the first screen that is displayed. It takes user input and compares it to the
 * existing files of users. Links to the register screen (add new user) and main menu.
 */
public class LoginScreen implements Screen {
	private Logger log = Logger.getRootLogger();

	@Override
	public Screen prompt() {
		//UserSerializer us = new UserSerializer();
		UserDAOjdbc userDao = new UserDAOjdbc();
		User currentUser;
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Revature Banking.");
		System.out.println("New users should enter \"new\" as a username " + "to register their account.");
		System.out.print("Enter Username: ");
		String input = scan.nextLine().toLowerCase();

		if (input.equals("new")) {
			System.out.println("");
			return new RegisterScreen();
		}
		
		// If it exists, ask for the password. If it doesn't exist, report invalid and reset screen.
		if (userDao.exists(input)) {
			//currentUser = us.DeserializeUser(input + ".txt");
			currentUser = userDao.getUser(input);
			
			if(currentUser == null) {
				System.out.println("Error retrieving user information. Try calling customer support.");
				return new LoginScreen();
			}
			System.out.print("Enter password: ");
			input = scan.nextLine();
			System.out.println("");
			
			// Check if password is correct and forward to main menu, otherwise report invalid and reset screen.
			if (input.equals(currentUser.getPassword()))
				return new MainMenu(currentUser);
			else {
				System.out.println("Invalid password, try again.\n");
				return new LoginScreen();
			}
		} else {
			System.out.println("Username does not exist, please try again.\n");
			return new LoginScreen();
		}
	}
}
