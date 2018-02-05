package com.bank.screens;

import java.util.Scanner;

import com.bank.util.UserSerializer;

/**
 * Checks if the user has more balance than what they attempt to withdraw,
 * before subtracting the specified input from their balance. Also checks their
 * input to determine validity.
 *
 */
public class WithdrawScreen implements Screen {

	@Override
	public Screen prompt() {
		Scanner scan = new Scanner(System.in);
		UserSerializer us = UserSerializer.getUserSerializer();

		System.out.println("Enter the amount you would like to withdraw.");
		String input = scan.next();

		// attempts to parse the input as a double, and if so, continues on with
		// transaction logic. If not a number, outputs the error and resets the page.

		try {
			double dinput = Double.parseDouble(input);
			if (dinput > us.getCurrentuser().getBalance())
			// if their input is more money than they have, it will not work.
			{
				System.out.println("Overdraft protection: Cannot withdraw more than current balance.");
				return new WithdrawScreen().prompt();
			} else {
				double bal = us.getCurrentuser().getBalance();
				us.getCurrentuser().setBalance(bal -= dinput);

				System.out.println("Your balance is now " + us.getCurrentuser().getBalance());
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a number to withdraw");
			return new WithdrawScreen().prompt();
		}

		us.serializeUser(us.getUsers());
		return new MainMenu().prompt();

	}

}
