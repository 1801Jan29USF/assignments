package com.bank.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.beans.AuthUser;
//import com.bank.util.UserSerializer;
import com.bank.dao.BankDAOJDBC;
import com.bank.dao.bankDAO;

public class DepositScreen implements Screen {
	Scanner scan = new Scanner(System.in);

	@Override
	public Screen prompt() {
		Logger log = Logger.getRootLogger();
		bankDAO bdao = BankDAOJDBC.getBdao();
	//	List<AuthUser> users = new ArrayList<AuthUser>();

		System.out.println("Enter the amount you would like to deposit.");
		String input = scan.next();

		// attempts to parse the input as a double, and if so, continues on to deposit
		// it. If it catches the number format exception, outputs the warning and
		// restarts the deposit page
		try {
			double dinput = Double.parseDouble(input);
			if (dinput < 0) {
				log.warn("Deposit amount cannot be negative.");
				return new DepositScreen().prompt();
			} else {
				bdao.deposit(bdao.getCurrentUserID(), dinput);
			}

		} catch (NumberFormatException e) {
			log.warn("Invalid input, give a number.");
			return new DepositScreen().prompt();
		}
		// checks to see if their deposit amount is above 0

		// us.serializeUser(users);
		return new MainMenu().prompt();
	}

}
