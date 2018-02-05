package com.revature.screens;

import com.revature.beans.BankUser;
import com.revature.util.BankUserSerializer;
import com.revature.util.CommandLineScannerSingleton;

/**
 * Screen that handles deposits for the user's account. Takes a deposit
 * amount from the user, updates the currentUser object, then serializes
 * that object to the associated .txt file, overwriting the obsolete
 * file. harmlessly boots the user back to the main menu in the event of an 
 * invalid input, a failure to serialize, or a deposit of $0.
 * @author poblo
 *
 */
public class DepositScreen implements Screen {
	BankUser user;

	public DepositScreen(BankUser user) {
		super();
		this.user = user;
	}

	@Override
	public Screen prompt() {
		System.out.println("Please enter the amount you would like to deposit:");
		String input = CommandLineScannerSingleton.getSc().next();
		Double balanceChange = 0.0;
		
		/*
		 * Tries to read a deposit amount from the user. If the amount cannot be
		 * parsed as a double, returns the user to the Main Menu.
		 */
		try {
			balanceChange = Double.parseDouble(input);
		} catch (Exception e) {
			System.out.println("I'm sorry, that is an invalid number");
			System.out.println("Press enter to return to Main Menu");
			CommandLineScannerSingleton.getSc().nextLine();
			CommandLineScannerSingleton.getSc().nextLine();
			return new MainMenu(this.user);
		}
		/*
		 * Returns the user to the Main Menu with a customized menu if they
		 * try to deposit $0.
		 */
		if (balanceChange == 0.0) {
			System.out.println("No money depositted.");
			System.out.println("Press enter to return to Main Menu");
			CommandLineScannerSingleton.getSc().nextLine();
			CommandLineScannerSingleton.getSc().nextLine();
			return new MainMenu(this.user);
		}
		/*
		 * Deposits the requested amount into the user's account, updating the
		 * current BankUser object before serializing it.
		 */
		try {
			user.deposit(balanceChange);
			user.addTransaction("Deposited", balanceChange);
			BankUserSerializer.attemptWriteBankUser(this.user, this.user.getFile());
			System.out.println("Your deposit has been successfully processed.");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("I'm sorry, this transaction failed.");
			System.out.println();
			user.safeWithdraw(balanceChange);
			user.cancelTransaction();
		}

		// Returns the user to the Main Menu
		System.out.println("Press enter to return to Main Menu");
		CommandLineScannerSingleton.getSc().nextLine();
		CommandLineScannerSingleton.getSc().nextLine();
		return new MainMenu(this.user);

	}

	public BankUser getUser() {
		return user;
	}


}
