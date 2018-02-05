package com.revature.screens;


import com.revature.beans.BankUser;
import com.revature.util.BankUserSerializer;
import com.revature.util.CommandLineScannerSingleton;

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
	BankUser user;

	public WithdrawScreen(BankUser user) {
		super();
		this.user = user;
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
			return new MainMenu(this.user);
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
			return new MainMenu(this.user);
		}
		/*
		 * Catches the user if they try to withdraw more than they have, booting
		 * them bck to the Main Menu
		 */
		try {
			user.withdraw(balanceChange);
		} catch (Exception e) {
			System.out.println("I'm sorry, you do not have enough money in your account for this transaction.");
			System.out.println("Press enter to return to Main Menu");
			CommandLineScannerSingleton.getSc().nextLine();
			CommandLineScannerSingleton.getSc().nextLine();
			System.out.println();
			return new MainMenu(this.user);
		}
		/*
		 * Withdraws the requested amount from the user's account, updating the
		 * current BankUser object before serializing it.
		 */
		try {
			this.user.addTransaction("Withdrew", balanceChange);
			BankUserSerializer.attemptWriteBankUser(this.user, this.user.getFile());
			System.out.println("Your withdrawal has been successfully processed.");
			System.out.println();
		} catch (Exception e) {
			System.out.println("I'm sorry, this transaction failed.");
			System.out.println();
			user.deposit(balanceChange);
			user.cancelTransaction();
		}
		// Returns the user to the Main Menu
		System.out.println("Press enter to return to Main Menu");
		input = CommandLineScannerSingleton.getSc().nextLine();
		input = CommandLineScannerSingleton.getSc().nextLine();
		return new MainMenu(this.user);


	}

	public BankUser getUser() {
		return user;
	}

	public void setUser(BankUser user) {
		this.user = user;
	}
	
	

}