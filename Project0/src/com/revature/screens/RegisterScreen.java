package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.DAO.UserDAOjdbc;
import com.revature.beans.User;

/**
 * This screen is used for registering a new user. Can only be reached from the LoginScreen 
 * and returns back there when finished
 * @author Ben Z
 *
 */
public class RegisterScreen implements Screen {
	private Logger log = Logger.getRootLogger();

	@Override
	public Screen prompt() {
		//UserSerializer us = new UserSerializer();
		UserDAOjdbc userDao = new UserDAOjdbc();
		Scanner scan = new Scanner(System.in);
		String nameInput;
		String passwordInput;
		String confirmPass;
		
		System.out.println("Hello there. Please fill out your user information.");
		System.out.print("Enter a new Username: ");
		nameInput = scan.nextLine().toLowerCase();
		System.out.println(nameInput);
		
		// Check if the name is already taken
		if(userDao.exists(nameInput)){
			System.out.println("User name already exists.\n");
			return new RegisterScreen();
		}
		
		System.out.print("Enter a password: ");
		passwordInput = scan.nextLine();
		System.out.print("Confirm your password: ");
		confirmPass = scan.nextLine();
		System.out.println("");

		// Make sure the passwords match. A common functionality when requiring users to create a password.
		if(!passwordInput.equals(confirmPass)) {
			System.out.println("Passwords did not match. Try again.\n");
			return new RegisterScreen();
		}
		
		// Save user to the file.
		User u = new User(1, nameInput, passwordInput, 0.0f);
		//us.SerializeUser(u, u.getUsername() + ".txt");
		int id = userDao.register(u);
		if(id == -1) {
			System.out.println("Error registering user.");
			return new RegisterScreen();
		}
		else
			log.trace("User created with id: " + id + "\n");
		
		return new LoginScreen();
	}
}
