package com.bank.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.BankDAOJDBC;
import com.bank.dao.bankDAO;

//import com.bank.util.UserSerializer;

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
	//	UserSerializer us = UserSerializer.getUserSerializer();
		
		Logger log = Logger.getRootLogger();
		bankDAO bdao = BankDAOJDBC.getBdao();

		System.out.println("Enter the amount you would like to withdraw.");
		String input = scan.next();

		// attempts to parse the input as a double, and if so, continues on with
		// transaction logic. If not a number, outputs the error and resets the page.

		try {
			double dinput = Double.parseDouble(input);
			if (dinput < 0)
			// if their input is less than zero, it will not work
			{
				log.warn("Please enter a number greater than zero.");
				return new WithdrawScreen().prompt();
			} else {
				bdao.withdraw(bdao.getCurrentUserID(), dinput);
			}
		} catch (NumberFormatException e) {
			log.warn("Invalid input. Please enter a number to withdraw");
			return new WithdrawScreen().prompt();
		}

//		us.serializeUser(bdao.getUsers());
		return new MainMenu().prompt();

	}

}
