package com.bank.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.beans.AuthUser;
import com.bank.util.UserSerializer;
import com.bank.screens.MainMenu;
import com.bank.screens.LoginScreen;

/**
 * First screen encountered in banking application. Searches our list of users
 * for their given input, and returns the main menu screen if it's a match!
 *
 */
public class LoginScreen implements Screen {

	public AuthUser currentuser;

	public AuthUser getCurrentuser() {
		return currentuser;
	}

	public void setCurrentuser(AuthUser currentuser) {
		this.currentuser = currentuser;
	}

	Scanner scan = new Scanner(System.in);

	UserSerializer us = UserSerializer.getUserSerializer();

	@Override
	public Screen prompt() {
		List<AuthUser> users = new ArrayList<AuthUser>();
		System.out.println("Welcome to login page. Enter your username, or type New to make a new account.");
		String inputname = scan.nextLine();

		// if the input is "new", gives sends to register screen!
		if (inputname.toLowerCase().equalsIgnoreCase("new")) {
			return new RegisterScreen().prompt();

			// otherwise, check every user in our list to see if the input matches a
			// username. could have made this a switch, but only two cases, so just used
			// single if statement for registering.
		} else {
			for (AuthUser u : us.getUsers()) {
				if (u.getUsername().equals(inputname)) {
					System.out.println("Enter your password.");
					String inputpass = scan.nextLine();
					if (inputpass.equals(u.getPassword())) {
						// if their user and pass match, they are set as the 'current user'
						us.setCurrentuser(u);
						return new MainMenu().prompt();

						// else boots them back to the login screen
					} else {
						System.out.println("Invalid credentials.");
						return new LoginScreen();
					}

				}
			}
		}

		return null;
	}

}
