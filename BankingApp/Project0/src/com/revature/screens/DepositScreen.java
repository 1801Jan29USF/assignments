package com.revature.screens;

import java.util.Scanner;

import com.revature.DAO.UserDAOjdbc;
import com.revature.beans.User;

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
		UserDAOjdbc userDao = new UserDAOjdbc();
		//UserSerializer us = new UserSerializer();
		Scanner scan = new Scanner(System.in);
		float oldBalance = currentUser.getBalance();
		
		System.out.println("How much would you like to deposit?");
		float depositInput = scan.nextFloat();
		if(depositInput < 0) {
			System.out.println("Please enter a positive number.\n");
			return new DepositScreen(currentUser);
		}
		
		float newBalance = oldBalance + depositInput;
		currentUser.setBalance(newBalance);
		// note the ! sign
		if(userDao.updateBalance(currentUser)) {
			System.out.println("Deposit Complete. Your new balance is: $" + newBalance);
		} else {
			System.out.println("Error while updating balance. Old balance has been restored.");
			currentUser.setBalance(oldBalance);
		}
		
		//currentUser.setBalance(currentUser.getBalance()+depositInput); 
		//System.out.println("Your new balance is: $" + currentUser.getBalance() + "\n");
		
		//us.SerializeUser(currentUser, currentUser.getUsername() + ".txt");
		System.out.println("");
		return new MainMenu(currentUser);
	}
}
