package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.dao.TransactionsDAOJDBC;

public class DepositScreen implements Screen {
	
	/*******************************************************************************
	  Class Fields
	********************************************************************************/

	private User curr;
	public Scanner scan = new Scanner(System.in);
	public TransactionsDAOJDBC dao = new TransactionsDAOJDBC();
	private Logger log = Logger.getRootLogger();

	/*******************************************************************************
	  Constructor
	********************************************************************************/
	
	public DepositScreen(User u) {
		super();
		this.curr = u;
		prompt();
	}

	/*******************************************************************************
	  Screen Prompt Method
	********************************************************************************/
	
	@Override
	public Screen prompt() {
		System.out.println("DEPOSIT \n");
		System.out.println("Please Enter Amount for Deposit: ");
		int depositAmt = 0;
		try {
			depositAmt = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			
			log.warn("user has entered an invalid type.");
			System.out.println("Invalid input for deposit\n");
			return new UserAccountScreen(curr);
		}
		if (depositAmt < 0) {
			
			log.warn("User has entered a negative value for deposit.");
			System.out.println("Deposit amount must be greater or equal to 0\n");
			return new UserAccountScreen(curr);
		}
		
		System.out.println("Enter account name for deposit");
		String acctName = scan.nextLine();
		dao.deposit(curr.userId, depositAmt, acctName);

		return new UserAccountScreen(curr);
	}

}
