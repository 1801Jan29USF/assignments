package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.file.io.UserSerializer;

/**
 * This screen is called from the main menu. Contains the logic for depositing money into the balance.
 * Upon creation, it must be passed a user object that represents the current user using the application.
 */
public class DepositScreen implements Screen {
	private User currentUser;
	
	public DepositScreen(User currentUser) {
		super();
		this.currentUser = currentUser;
	}

	@Override
	public Screen prompt() {
		UserSerializer us = new UserSerializer();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How much would you like to deposit?");
		float depositInput = scan.nextFloat();
		
		currentUser.setBalance(currentUser.getBalance()+depositInput); 
		System.out.println("Your new balance is: $" + currentUser.getBalance() + "\n");
		
		us.SerializeUser(currentUser, currentUser.getUsername() + ".txt");
		
		return new MainMenu(currentUser);
	}
}
