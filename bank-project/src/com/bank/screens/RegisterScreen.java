package com.bank.screens;

import java.util.Scanner;

import com.bank.beans.AuthUser;
import com.bank.util.UserSerializer;

/**
 * @author Assigns a username, password and starting balance to user input, adds
 *         them to the arraylist of authenticated users and serializes the list!
 *         Upon creation of a new user, the system outputs a list of all current
 *         users for the dev testing purposes, but the toString method does not
 *         include their password for 'security' purposes.
 *
 */
public class RegisterScreen implements Screen {

	Scanner scan = new Scanner(System.in);
	UserSerializer us = UserSerializer.getUserSerializer();

	@Override
	public Screen prompt() {
		System.out.println("Enter a username.");
		String newname = scan.nextLine();
		
		
		//checks if the new username already exists before allowing the user to continue.
		for (AuthUser u : us.getUsers()) {
			if (u.getUsername().equals(newname)) {
				System.out.println("Username already exists!");
				return new RegisterScreen().prompt();
			}
		}

		System.out.println("Choose a password.");
		String newpass = scan.nextLine();
		System.out.println("Confirm your password.");
		String newpass2 = scan.nextLine();

		if (!newpass.equals(newpass2)) {
			System.out.println("Passwords do not match.");
			return new RegisterScreen();
		}

		System.out.println("What is your starting balance?");
		double newbal = scan.nextDouble();
		int registers;
		registers = us.getUsers().size() + 1;

		// new user object created with input
		AuthUser newuser = new AuthUser(registers, newname, newpass, newbal);

		// adds to list and serializes
		us.addUser(newuser);
		us.serializeUser(us.getUsers());

		return null;
	}

}
