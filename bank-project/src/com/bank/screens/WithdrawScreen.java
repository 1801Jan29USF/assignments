package com.bank.screens;

import java.util.Scanner;

import com.bank.util.UserSerializer;

/**
 * Checks if the user has more balance than what they attempt to withdraw,
 * before subtracting the specified input from their balance.
 *
 */
public class WithdrawScreen implements Screen {

	@Override
	public Screen prompt() {
		Scanner scan = new Scanner(System.in);
		UserSerializer us = UserSerializer.getUserSerializer();

		System.out.println("Enter the amount you would like to withdraw.");
		double input = scan.nextDouble();

		// if their input is more money than they have, it will not work.
		if (input > us.getCurrentuser().getBalance()) {
			System.out.println("Overdraft protection: Cannot withdraw more than current balance.");
			return new WithdrawScreen().prompt();
		} else {
			double bal = us.getCurrentuser().getBalance();
			us.getCurrentuser().setBalance(bal -= input);

			System.out.println("Your balance is now " + us.getCurrentuser().getBalance());
		}
		us.serializeUser(us.getUsers());
		return new MainMenu().prompt();

	}

}
