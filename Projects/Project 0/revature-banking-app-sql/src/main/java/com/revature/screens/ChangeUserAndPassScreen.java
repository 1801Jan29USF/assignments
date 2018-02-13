package com.revature.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.dao.TransactionsDAOJDBC;

/*
 *From this screen Users can change their Username and Password
 *while mainting all past data and transactions 
 */

public class ChangeUserAndPassScreen implements Screen {
	
	/*******************************************************************************
	   Class Fields
	********************************************************************************/
	
	private User curr;
	public Scanner scan = new Scanner(System.in);
	public TransactionsDAOJDBC dao = new TransactionsDAOJDBC();
	private Logger log = Logger.getRootLogger();
	
	/*******************************************************************************
	   Class Constructor
	********************************************************************************/

	public ChangeUserAndPassScreen(User c) {
		super();
		this.curr = c;
		prompt();
	}
	
	/*******************************************************************************
	  Screen Prompt Method
	********************************************************************************/
	
	@Override
	public Screen prompt() {
		System.out.println("ACCOUNT/PASSWORD CHANGE\n");
		System.out.println("Please enter your new Username: \n");
		String username = scan.nextLine();
		System.out.println("Please enter your new Password: \n");
		String password = scan.nextLine();
		
		//prevents user from changing username to current username
		if (username.equals(curr.getUsername())) {
			System.out.println("That is your current username. Please pick another.\n");
			return new ChangeUserAndPassScreen(curr);
		}
		
		log.trace("attempting to change user's credentials");
		//if new account name doesn't exist change it
		if (dao.updateUserPass(curr.getId(), username, password)) {
			System.out.println("Your username and password have been updated.\n");
			//update credentials of curr
			curr.setUsername(username);
			curr.setPassword(password);
			
			log.trace("curr credentials have been updateds");
			return new UserAccountScreen(curr);
		}
		System.out.println("Chosen username already exists. Please choose a new usename.\n");
		return new UserAccountScreen(curr);
	}
}
