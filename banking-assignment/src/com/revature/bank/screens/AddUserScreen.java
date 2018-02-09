package com.revature.bank.screens;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.bank.bean.User;
import com.revature.bank.utility.BankSerializer;

/**
 * AddUser Screen allows user to register for new account. If user already
 * exits, it prompt user to choose different user name. User creates new user,
 * password, add first deposit to balance. Once user is registered, the data is
 * created and save in a txt file through serialization.
 * 
 */

public class AddUserScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private BankSerializer bs = new BankSerializer();

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

		newUser = new User(username, password, balance);
		File f = new File(username + ".txt");
		if (f.exists()) {
			System.out.println("User already exist, Pleas choose differnt username");
			return new AddUserScreen();
		} else {
			newUser = new User(username, password, balance);

			bs.SerilaziableBank(newUser, username);
			System.out.println("You have susccessfull regstered new account");
			bs.DeserializeBank(username);
			System.out.println(newUser.toString());

			return new LoginScreen();
		}

	}

}
