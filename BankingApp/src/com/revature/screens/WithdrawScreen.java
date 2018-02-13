package com.revature.screens;

import com.revature.exceptions.InvalidPasswordException;
import com.revature.exceptions.OverdraftException;
import com.revature.util.CommandLineScannerSingleton;
import com.revature.util.JDBCSingleton;

/**
 * Screen that handles withdrawals for the user's account. Takes a withdrawal
 * amount from the user, updates the currentUser object, then serializes
 * that object to the associated .txt file, overwriting the obsolete
 * file. Harmlessly boots the user back to the main menu in the event of an 
 * invalid input, a failure to serialize, or an attempt to withdraw more
 * money than exists in the account.
 * @author poblo
 *
 */
public class WithdrawScreen implements Screen {
	String username;

	public WithdrawScreen(String username) {
		super();
		this.username = username;
	}

	@Override
	public Screen prompt() {
		System.out.println("Please enter the amount you would like to withdraw:");
		String input = CommandLineScannerSingleton.getSc().next();
		Double balanceChange = 0.0;
		
		/*
		 * Tries to read a withdrawal amount from the user. If the amount cannot be
		 * parsed as a double, returns the user to the Main Menu.
		 */
		try {
			balanceChange =  Double.parseDouble(input);
		} catch (Exception e) {
			System.out.println("I'm sorry, that is an invalid number");
			System.out.println("Press enter to return to Main Menu");
			CommandLineScannerSingleton.getSc().nextLine(); 
			CommandLineScannerSingleton.getSc().nextLine();
			return new MainMenu(this.username);
		}
		/*
		 * Returns the user to the Main Menu with a customized menu if they
		 * try to withdraw $0.
		 */
		if (balanceChange == 0.0) {
			System.out.println("No money withdrawn.");
			System.out.println("Press enter to return to Main Menu");
			CommandLineScannerSingleton.getSc().nextLine(); 
			CommandLineScannerSingleton.getSc().nextLine();
			return new MainMenu(this.username);
		}
		/*
		 * Catches the user if they try to withdraw more than they have, booting
		 * them bck to the Main Menu
		 */
		System.out.println("Please verify your password for this transaction:");
		input = CommandLineScannerSingleton.getSc().next();
		try {
			JDBCSingleton.getJD().withdraw(username, input, balanceChange);
		}catch (InvalidPasswordException e) {
			System.out.println("I'm sorry, that password is incorrect.");
			System.out.println("Press enter to return to Main Menu");
			CommandLineScannerSingleton.getSc().nextLine();
			CommandLineScannerSingleton.getSc().nextLine();
			System.out.println();
			return new MainMenu(this.username);
		}catch (OverdraftException e) {
			System.out.println("I'm sorry, you do not have enough money in your account for this transaction.");
			System.out.println("Press enter to return to Main Menu");
			CommandLineScannerSingleton.getSc().nextLine();
			CommandLineScannerSingleton.getSc().nextLine();
			System.out.println();
			return new MainMenu(this.username);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("I'm sorry, something went wrong with this transaction.");
			System.out.println("Press enter to return to Main Menu");
			CommandLineScannerSingleton.getSc().nextLine();
			CommandLineScannerSingleton.getSc().nextLine();
			System.out.println();
			return new MainMenu(this.username);
		}

		// Returns the user to the Main Menu
		System.out.println("Your withdrawal has been successfully processed!");
		System.out.println("Press enter to return to Main Menu");
		input = CommandLineScannerSingleton.getSc().nextLine();
		input = CommandLineScannerSingleton.getSc().nextLine();
		return new MainMenu(this.username);


	}
	

}