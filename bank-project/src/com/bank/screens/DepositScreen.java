package com.bank.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.beans.AuthUser;
import com.bank.util.UserSerializer;

public class DepositScreen implements Screen {
	Scanner scan = new Scanner(System.in);

	@Override
	public Screen prompt() {
		UserSerializer us = UserSerializer.getUserSerializer();
		List<AuthUser> users = new ArrayList<AuthUser>();
		users = us.getUsers();
		AuthUser current = us.getCurrentuser();

		System.out.println("Enter the amount you would like to deposit.");
		String input = scan.next();

		// attempts to parse the input as a double, and if so, continues on to deposit
		// it. If it catches the number format exception, outputs the warning and
		// restarts the deposit page
		try {
			double dinput = Double.parseDouble(input);
			if (dinput < 0) {
				System.out.println("Deposit amount cannot be negative.");
				return new DepositScreen().prompt();
			} else {
				double bal = current.getBalance();
				current.setBalance(bal += dinput);
				System.out.println("Your balance is now " + current.getBalance());
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid input, give a number.");
			return new DepositScreen().prompt();
		}
		// double input = scan.nextDouble();
		// checks to see if their deposit amount is above 0

		us.serializeUser(users);
		return new MainMenu().prompt();
	}

}
