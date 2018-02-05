package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.file.io.UserSerializer;

/**
 * This screen is used for registering a new user. Can only be reached from the LoginScreen 
 * and returns back there when finished
 * @author Ben Z
 *
 */
public class RegisterScreen implements Screen {

	@Override
	public Screen prompt() {
		UserSerializer us = new UserSerializer();
		Scanner scan = new Scanner(System.in);
		String nameInput;
		String passwordInput;
		String confirmPass;
		
		System.out.println("Hello there. Please fill out your user information.");
		System.out.print("Enter a new Username: ");
		nameInput = scan.nextLine();
		
		// Check if the name is already taken
		if( us.exists(nameInput + ".txt")){
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
		User u = new User(nameInput, passwordInput, 0.0f);
		us.SerializeUser(u, u.getUsername() + ".txt");
		
		return new LoginScreen();
	}
}
