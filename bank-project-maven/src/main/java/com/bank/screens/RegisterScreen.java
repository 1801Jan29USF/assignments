package com.bank.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.beans.AuthUser;
//import com.bank.util.UserSerializer;
import com.bank.dao.BankDAOJDBC;
import com.bank.dao.bankDAO;

/**
 * @author Assigns a username, password and starting balance to user input, adds
 *         them to the arraylist of authenticated users and serializes the list!
 *         Upon creation of a new user, the system outputs a list of all current
 *         users for the dev testing purposes, but the toString method does not
 *         include their password for 'security' purposes.
 *
 */
public class RegisterScreen implements Screen {

	bankDAO bdao = BankDAOJDBC.getBdao();
	Logger log = Logger.getRootLogger();

	Scanner scan = new Scanner(System.in);
	// UserSerializer us = UserSerializer.getUserSerializer();

	@Override
	public Screen prompt() {
		System.out.println("Enter a username.");
		String newname = scan.nextLine();

		log.trace("Choose a password.");
		String newpass = scan.nextLine();
		log.trace("Confirm your password.");
		String newpass2 = scan.nextLine();

		if (!newpass.equals(newpass2)) {
			log.warn("Passwords do not match.");
			return new RegisterScreen();
		}

		log.trace("What is your starting balance?");
		double newbal = scan.nextDouble();

		// new user object created with input
		AuthUser newuser = new AuthUser(0, newname, newpass, newbal);

		// adds to list and serializes
		bdao.addUser(newuser);
		// us.serializeUser(us.getUsers());

		return null;
	}

}
