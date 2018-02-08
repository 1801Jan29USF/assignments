package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.file.io.UserSerializer;

/**
 * This screen is used to subtract money from the user's balance. Can be accessed
 * from the MainMenu and returns there when finished.
 * @author Maara
 *
 */
public class WithdrawalScreen implements Screen {
	private User currentUser;
	
	public WithdrawalScreen(User currentUser) {
		super();
		this.currentUser = currentUser;
	}

	@Override
	public Screen prompt() {
		UserSerializer us = new UserSerializer();
		Scanner scan = new Scanner(System.in);

		System.out.println("How much would you like to withdraw?");
		float withdrawInput = scan.nextFloat();

		// Check if they have enough funds.
		if(currentUser.getBalance() - withdrawInput < 0) {
			System.out.println("Error. Insufficient funds.");
			return new WithdrawalScreen(currentUser);
		} else {
			currentUser.setBalance(currentUser.getBalance() - withdrawInput);
		}
		
		// Save the new balance.
		us.SerializeUser(currentUser, currentUser.getUsername() + ".txt");
		System.out.println("Your new balance is: $" + currentUser.getBalance() + "\n");
		
		return new MainMenu(currentUser);
	}

}
