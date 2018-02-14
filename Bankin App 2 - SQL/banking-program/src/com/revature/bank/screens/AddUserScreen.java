package com.revature.bank.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bank.bean.User;
import com.revature.bank.dao.AddUserDAO;
import com.revature.bank.dao.AddUserDAOJDBC;
import com.revature.bank.utility.BankSerializer;

/**
 * AddUser Screen allows user to register for new account. If user already
 * exits, it prompt user to choose different user name. User creates new user,
 * password, add first deposit to balance. Once user is registered, the data is
 * created and save in a txt file through serialization.
 * 
 */

public class AddUserScreen implements Screen {
	private Logger log = Logger.getRootLogger();

	private Scanner scan = new Scanner(System.in);
	

	private User newUser;

	@Override
	public Screen prompt() {
		System.out.println("------New user registration------");
		System.out.println("Please enter a username");
		String username = scan.nextLine();
		System.out.println("Please enter a password");
		String password = scan.nextLine();
		System.out.println("Please enter intital amaount to add to account");
		double balance = Double.parseDouble(scan.nextLine());

		AddUserDAO user = new AddUserDAOJDBC();
		newUser = user.checkIfUser(username);

		if (user.checkIfUser(username) != null) {
			if (!username.equals(newUser.getUserName())) {

			}
			System.out.println("User already exist, Please choose differnt username");
			System.out.println("--------------------------------------------------");
			return new AddUserScreen();

		} else {
			user.addUser(username, password, balance);
			System.out.println("You have susccessfull registered a  new account");
			System.out.println("---------------Welcome---------------------");
			

		}

		return new LoginScreen();
	}

}
