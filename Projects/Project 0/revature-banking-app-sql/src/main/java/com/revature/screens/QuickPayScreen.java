package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.dao.TransactionsDAOJDBC;

public class QuickPayScreen implements Screen {
	
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
	

	public QuickPayScreen(User u) {
		super();
		this.curr = u;
		prompt();
	}
	
	/*******************************************************************************
	  Screen Prompt Method
	********************************************************************************/

	@Override
	public Screen prompt() {
		System.out.println("QUICKPAY \n");
		System.out.println("Enter The Account Name you would like to send from: ");
		String acct = scan.nextLine();
		System.out.println("Enter Receiver's Account Name: ");
		String receiver = scan.nextLine();
		System.out.println("Enter amount to send: ");
		int amount = 0;
		try {
			amount = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			
			log.trace("invalid input type");
			System.out.println("Invalid input for Quickpay\n");
		}
		if (amount < 0) {
			System.out.println("Quickpay amount must be greater or equal to 0\n");
			return new UserAccountScreen(curr);
		}
		dao.quickPay(acct, receiver, curr.getId(), amount);

		return new UserAccountScreen(curr);
	}

}
