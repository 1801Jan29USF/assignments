package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.dao.TransactionsDAOJDBC;

public class TransferScreen implements Screen {

	/*******************************************************************************
	 * Class Fields
	 ********************************************************************************/

	private User curr;
	public Scanner scan = new Scanner(System.in);
	public TransactionsDAOJDBC dao = new TransactionsDAOJDBC();
	private Logger log = Logger.getRootLogger();

	/*******************************************************************************
	 * Constructor
	 ********************************************************************************/

	public TransferScreen(User curr) {
		super();
		this.curr = curr;
		prompt();
	}

	/*******************************************************************************
	 * Screen Prompt
	 ********************************************************************************/

	@Override
	public Screen prompt() {
		System.out.println("TRANSFER \n");
		System.out.println("Which account would you like to transfer money from?\n");
		String acctFrom = scan.nextLine();
		System.out.println("Which account would you like to transfer money to?\n");
		String acctTo = scan.nextLine();
		System.out.println("Enter amount for transfer\n");
		int transferAmt = 0;
		try {
			transferAmt = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {

			log.trace("invalid type of input ");
			System.out.println("Invalid input for transfer\n");
			return new UserAccountScreen(curr);
		}
		if (transferAmt < 0) {
			System.out.println("Transfer amount must be greater or equal to 0\n");
			return new UserAccountScreen(curr);
		}
		dao.transfer(curr.getId(), transferAmt, acctFrom, acctTo);
		return new UserAccountScreen(curr);
	}

}
