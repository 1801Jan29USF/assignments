package com.revature.screens;

import java.util.Scanner;

import com.revature.DAO.UserDAOjdbc;
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
		UserDAOjdbc userDao = new UserDAOjdbc();
		//UserSerializer us = new UserSerializer();
		Scanner scan = new Scanner(System.in);
		float oldBalance = currentUser.getBalance();

		System.out.println("How much would you like to withdraw?");
		float withdrawInput = scan.nextFloat();

		// Check if they have enough funds.
		if(currentUser.getBalance() - withdrawInput < 0) {
			System.out.println("Error. Insufficient funds.");
			return new WithdrawalScreen(currentUser);
		} else {
			currentUser.setBalance(currentUser.getBalance() - withdrawInput);
			if(userDao.updateBalance(currentUser)) {
				System.out.println("Withdrawal complete. Your new balance is: " + currentUser.getBalance());
			} else {
				System.out.println("Error while updating balance. Old balance has been restored.");
				currentUser.setBalance(oldBalance);
			}
		}
		
		// Save the new balance.
		//us.SerializeUser(currentUser, currentUser.getUsername() + ".txt");
		//System.out.println("Your new balance is: $" + currentUser.getBalance() + "\n");
		System.out.println("");
		return new MainMenu(currentUser);
	}

}
